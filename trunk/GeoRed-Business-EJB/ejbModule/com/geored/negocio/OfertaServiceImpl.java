package com.geored.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.geored.dominio.Local;
import com.geored.dominio.Oferta;
import com.geored.dominio.Tematica;
import com.geored.dominio.Usuario;
import com.geored.dto.NotificacionDTO;
import com.geored.dto.OfertaDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.LocalDAO;
import com.geored.persistencia.NotificacionDAO;
import com.geored.persistencia.OfertaDAO;
import com.geored.persistencia.TematicaDAO;
import com.geored.persistencia.TipoNotificacionDAO;
import com.geored.persistencia.UsuarioDAO;
import com.geored.utiles.AndroidGCMPushNotification;
import com.geored.utiles.ConstantesGenerales;
import com.geored.utiles.JsonParamsMap;
import com.geored.utiles.UtilesNegocio;
import com.google.gson.Gson;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class OfertaServiceImpl implements OfertaService
{
	@EJB
	private OfertaDAO ofertaDAO;
	
	@EJB
	private LocalDAO localDAO;
	
	@EJB
	private TematicaDAO tematicaDAO;
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@EJB
	private NotificacionDAO notificacionDAO;
	
	@EJB
	private TipoNotificacionDAO tipoNotificacionDAO;
	
	@WebMethod
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("insertar"))
		{		
			OfertaDTO ofertaDTO = (OfertaDTO) params.getParam("ofertaDTO", OfertaDTO.class);
			
			return new Gson().toJson(insertar(ofertaDTO));
		}
		else if(methodName.equals("actualizar"))
		{		
			OfertaDTO ofertaDTO = (OfertaDTO) params.getParam("ofertaDTO", OfertaDTO.class);
			
			actualizar(ofertaDTO);
		} 
		else if(methodName.equals("eliminar"))
		{		
			Long idOferta= (Long) params.getParam("idOferta", Long.class);
			
			eliminar(idOferta);
		}
		else if(methodName.equals("obtener"))
		{		
			Long idOferta = (Long) params.getParam("idOferta", Long.class);
			
			return new Gson().toJson(obtener(idOferta));
		}
		else if(methodName.equals("obtenerListado"))
		{		
			return new Gson().toJson(obtenerListado());
		}
		
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(@WebParam(name="ofertaDTO") OfertaDTO ofertaDTO) throws NegocioException, DaoException
	{
		if(ofertaDAO.obtenerPorNombreYLocal(ofertaDTO.getNombre(), ofertaDTO.getIdLocal(), false) != null)
		{
			throw new NegocioException("Ya existe una oferta con este nombre para el local indicado");
		}
		
		Oferta ofertaEntity = ofertaDAO.toEntity(ofertaDTO);
		
		Local localEntity = (Local) localDAO.obtener(ofertaDTO.getIdLocal(), false);
		
		if(localEntity == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		ofertaEntity.setLocal(localEntity);
		
		asociarTematicas(ofertaDTO, ofertaEntity);
		
		ofertaDAO.insertar(ofertaEntity);
		
		/* 
		 * Notifico a los usuarios con las mismas tematicas que la oferta
		 */
		List<Long> idsTematicas = new ArrayList<Long>();
		for(Tematica tematica : ofertaEntity.getListaTematicas())
		{
			idsTematicas.add(tematica.getId());
		}
		
		List<Usuario> listadoUsuariosConTematicas = usuarioDAO.obtenerListadoPorTematica(idsTematicas, false);
		
		for(Usuario usuario : listadoUsuariosConTematicas)
		{	
			// Si el usaurio destino tiene el gcm reg id envio al movil
			if(!UtilesNegocio.isNullOrEmpty(usuario.getGcmRegId()))
			{					
				NotificacionDTO notificacionDTO = new NotificacionDTO();
				
				notificacionDTO.setDescripcion("Se ha creado una oferta nueva");
				
				notificacionDTO.setLeida(false);
				
				notificacionDTO.setIdTipoNotificacion(ConstantesGenerales.TiposNotificacion.ID_NUEVA_OFERTA);
				
				notificacionDTO.setIdUsuarioDestino(usuario.getId());
				
				notificacionDTO.setMetadataNotif(ofertaEntity.getId().toString() + ";" + ofertaEntity.getLocal().getUbicacionGeografica());
				
				// Invoco el GCM
				List<String> androidTargets = new ArrayList<String>();
				
				androidTargets.add(usuario.getGcmRegId());
				
				AndroidGCMPushNotification.enviarNotificaciones(androidTargets, notificacionDTO);
			}
		}
		
		return ofertaEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(@WebParam(name="ofertaDTO") OfertaDTO ofertaDTO) throws NegocioException, DaoException
	{
		Oferta ofertaEntity = (Oferta) ofertaDAO.obtenerPorNombreYLocal(ofertaDTO.getNombre(), ofertaDTO.getIdLocal(), false);
		
		if(ofertaEntity != null && !ofertaEntity.getId().equals(ofertaDTO.getId()))
		{	
			throw new NegocioException("Ya existe una oferta con este nombre para el local indicado");
		}		
				
		ofertaEntity = (Oferta) ofertaDAO.obtener(ofertaDTO.getId(), false);
		
		if(ofertaEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		ofertaDAO.toEntity(ofertaDTO, ofertaEntity);
		
		Local localEntity = (Local) localDAO.obtener(ofertaDTO.getIdLocal(), false);
		
		if(localEntity == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		ofertaEntity.setLocal(localEntity);
		
		asociarTematicas(ofertaDTO, ofertaEntity);
		
		ofertaDAO.actualizar(ofertaEntity);			
	}
	
	private void asociarTematicas(OfertaDTO ofertaDTO, Oferta ofertaEntity) throws DaoException, NegocioException
	{
		// Cargo la lista de tematicas para la oferta
		if(ofertaEntity.getListaTematicas() == null)
		{
			ofertaEntity.setListaTematicas(new ArrayList<Tematica>());
		}
		else
		{
			ofertaEntity.getListaTematicas().clear();
		}
		
		if(ofertaDTO.getListaTematicasDTO() != null)
		{			
			for(TematicaDTO tematicaDTO : ofertaDTO.getListaTematicasDTO())
			{
				Tematica tematica = (Tematica) tematicaDAO.obtener(tematicaDTO.getId(), false);
				
				if(tematica == null)
				{
					throw new NegocioException("La tematica (" + tematicaDTO.getId() + ") no existe");
				}
				
				ofertaEntity.getListaTematicas().add(tematica);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(@WebParam(name="idOferta") Long idOferta) throws NegocioException, DaoException
	{
		Oferta ofertaEntity = (Oferta) ofertaDAO.obtener(idOferta, false);
		
		if(ofertaEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		ofertaDAO.eliminar(ofertaEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public OfertaDTO obtener(@WebParam(name="idOferta") Long idOferta) throws NegocioException, DaoException
	{
		OfertaDTO ofertaDTO = (OfertaDTO) ofertaDAO.obtener(idOferta, true);
		
		if(ofertaDTO == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		return ofertaDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<OfertaDTO> obtenerListado() throws DaoException
	{
		return ofertaDAO.obtenerListado(true);		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<OfertaDTO> obtenerListadoPorEmpresa(@WebParam(name="idEmpresa") Long idEmpresa) throws DaoException
	{
		return ofertaDAO.obtenerListadoPorEmpresa(idEmpresa, true);
	}
}
