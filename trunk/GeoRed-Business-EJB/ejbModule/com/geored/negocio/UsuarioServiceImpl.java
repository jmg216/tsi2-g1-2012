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

import com.geored.dominio.Amistad;
import com.geored.dominio.MensajeAmistad;
import com.geored.dominio.Notificacion;
import com.geored.dominio.Tematica;
import com.geored.dominio.TipoNotificacion;
import com.geored.dominio.Usuario;
import com.geored.dto.CheckInDTO;
import com.geored.dto.MensajeAmistadDTO;
import com.geored.dto.NotificacionDTO;
import com.geored.dto.TematicaDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.AmistadDAO;
import com.geored.persistencia.CheckInDAO;
import com.geored.persistencia.MensajeAmistadDAO;
import com.geored.persistencia.NotificacionDAO;
import com.geored.persistencia.TematicaDAO;
import com.geored.persistencia.TipoNotificacionDAO;
import com.geored.persistencia.UsuarioDAO;
import com.geored.utiles.AndroidGCMPushNotification;
import com.geored.utiles.JsonParamsMap;
import com.google.gson.Gson;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class UsuarioServiceImpl implements UsuarioService
{
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@EJB
	private CheckInDAO checkInDAO;
	
	@EJB
	private MensajeAmistadDAO mensajeAmistadDAO;
	
	@EJB
	private AmistadDAO amistadDAO;
	
	@EJB
	private NotificacionDAO notificacionDAO;
	
	@EJB
	private TipoNotificacionDAO tipoNotificacionDAO;
	
	@EJB
	private TematicaDAO tematicaDAO;
	
	@WebMethod(operationName="androidInvocation")
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("insertar"))
		{		
			UsuarioDTO usuarioDTO = (UsuarioDTO) params.getParam("usuariODTO", UsuarioDTO.class);
			
			Long idUsuario = insertar((UsuarioDTO) usuarioDTO);
			
			return new Gson().toJson(idUsuario);
		}
		else if(methodName.equals("actualizar"))
		{
			UsuarioDTO usuarioDTO = (UsuarioDTO) params.getParam("usuariODTO", UsuarioDTO.class);
			
			actualizar(usuarioDTO);
		}
		else if(methodName.equals("eliminar"))
		{
			Long idUsuario = (Long) params.getParam("idUsuario", Long.class);
			
			eliminar(idUsuario);
		}
		else if(methodName.equals("obtener"))
		{
			Long idUsuario = (Long) params.getParam("idUsuario", Long.class);
			
			UsuarioDTO usuarioDTO = obtener(idUsuario);
			
			return new Gson().toJson(usuarioDTO);
		}
		else if(methodName.equals("obtenerListado"))
		{
			return new Gson().toJson(obtenerListado());
		}
		else if(methodName.equals("obtenerPorEmailYPass"))
		{
			String email = (String) params.getParam("email", String.class);
			String pass = (String) params.getParam("pass", String.class);
			
			UsuarioDTO usuarioDTO = obtenerPorEmailYPass(email, pass);
			
			return new Gson().toJson(usuarioDTO);
		}
		else if(methodName.equals("obtenerListadoCheckIns"))
		{
			return new Gson().toJson(obtenerListadoCheckIns());
		}
		else if(methodName.equals("enviarMensajeChat"))
		{
			MensajeAmistadDTO mensajeAmistadDTO = (MensajeAmistadDTO) params.getParam("mensajeAmistadDTO", MensajeAmistadDTO.class);
			
			Long idMensaje = enviarMensajeChat(mensajeAmistadDTO);
			
			return new Gson().toJson(idMensaje);
		}
		else if(methodName.equals("enviarNotificacion"))
		{
			NotificacionDTO notificacionDTO = (NotificacionDTO) params.getParam("notificacionDTO", NotificacionDTO.class);
			
			Long idNotificacion = enviarNotificacion(notificacionDTO);
			
			return new Gson().toJson(idNotificacion);
		}
	
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod(operationName="insertar")
	public Long insertar(@WebParam(name="usuarioDTO") UsuarioDTO usuarioDTO) throws NegocioException, DaoException
	{
		if(usuarioDAO.obtenerUsuarioPorEmail(usuarioDTO.getEmail(), false) != null)
		{
			throw new NegocioException("Ya existe un usuario con este mail");
		}
		
		Usuario usuarioEntity = usuarioDAO.toEntity(usuarioDTO);
		
		asociarTematicas(usuarioDTO, usuarioEntity);
		
		usuarioDAO.insertar(usuarioEntity);
		
		return usuarioEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod(operationName="actualizar")
	public void actualizar(@WebParam(name="usuarioDTO") UsuarioDTO usuarioDTO) throws NegocioException, DaoException
	{
		Usuario usuarioEntity = (Usuario) usuarioDAO.obtenerUsuarioPorEmail(usuarioDTO.getEmail(), false); 
				
		if(usuarioEntity != null && !usuarioEntity.getId().equals(usuarioDTO.getId()))
		{
			throw new NegocioException("Ya existe un usuario con este email");
		}
		
		usuarioEntity = (Usuario) usuarioDAO.obtener(usuarioDTO.getId(), false);
		
		if(usuarioEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		usuarioDAO.toEntity(usuarioDTO, usuarioEntity);
		
		asociarTematicas(usuarioDTO, usuarioEntity);
		
		usuarioDAO.actualizar(usuarioEntity);			
	}
	
	private void asociarTematicas(UsuarioDTO usuarioDTO, Usuario usuarioEntity) throws DaoException, NegocioException
	{
		// Cargo la lista de tematicas para el sitio
		if(usuarioEntity.getListaTematicas() == null)
		{
			usuarioEntity.setListaTematicas(new ArrayList<Tematica>());
		}
		else
		{
			usuarioEntity.getListaTematicas().clear();
		}
		
		if(usuarioDTO.getListaTematicasDTO() != null)
		{			
			for(TematicaDTO tematicaDTO : usuarioDTO.getListaTematicasDTO())
			{
				Tematica tematica = (Tematica) tematicaDAO.obtener(tematicaDTO.getId(), false);
				
				if(tematica == null)
				{
					throw new NegocioException("La tematica (" + tematicaDTO.getId() + ") no existe");
				}
				
				usuarioEntity.getListaTematicas().add(tematica);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod(operationName="eliminar") 
	public void eliminar(@WebParam(name="idUsuario") Long idUsuario) throws NegocioException, DaoException
	{
		Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(idUsuario, false);
		
		if(usuarioEntity == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		usuarioDAO.eliminar(usuarioEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtener")
	public UsuarioDTO obtener(@WebParam(name="idUsuario") Long idUsuario) throws NegocioException, DaoException
	{
		UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtener(idUsuario, true);
		
		if(usuarioDTO == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		return usuarioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerListado")
	public List<UsuarioDTO> obtenerListado() throws DaoException
	{
		return usuarioDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerPorEmailYPass")
	public UsuarioDTO obtenerPorEmailYPass(@WebParam(name="email") String email, @WebParam(name="pass") String pass) throws NegocioException, DaoException
	{
		UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtenerUsuarioPorEmailYPass(email, pass, true);
		
		if(usuarioDTO == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		else
		{
			AndroidGCMPushNotification.enviarNotificaciones("10", usuarioDTO.getGcmRegId(), "Se ha logueado correctamente.");
		}
		
		return usuarioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerListadoCheckIns")
	public List<CheckInDTO> obtenerListadoCheckIns() throws DaoException
	{
		return checkInDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="enviarMensajeChat")
	public Long enviarMensajeChat(@WebParam(name="mensajeAmistadDTO") MensajeAmistadDTO mensajeAmistadDTO) throws NegocioException, DaoException
	{
		MensajeAmistad mensajeAmistad = mensajeAmistadDAO.toEntity(mensajeAmistadDTO);
		
		Amistad amistad = (Amistad) amistadDAO.obtener(mensajeAmistadDTO.getIdAmistad(), false);
		
		if(amistad == null)
		{
			throw new NegocioException("Amistad no encontrada");
		}
		
		Usuario remitente = (Usuario) usuarioDAO.obtener(mensajeAmistadDTO.getIdRemitente(), false);
		
		if(remitente == null)
		{
			throw new NegocioException("Remitente no encontrado");
		}
		
		mensajeAmistad.setAmistad(amistad);
		
		mensajeAmistad.setRemitente(remitente);
		
		mensajeAmistadDAO.insertar(mensajeAmistad);
		
		Long idDestinatario = amistad.getUsuarioA().getId();
		
		if(idDestinatario.equals(remitente.getId()))
		{
			idDestinatario = amistad.getUsuarioB().getId();
		}
		
		AndroidGCMPushNotification.enviarNotificaciones("10", idDestinatario.toString(), mensajeAmistad.getMensaje());
		
		return mensajeAmistad.getId();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="enviarNotificacion")
	public Long enviarNotificacion(@WebParam(name="notificacionDTO") NotificacionDTO notificacionDTO) throws NegocioException, DaoException
	{
		Notificacion notificacion = notificacionDAO.toEntity(notificacionDTO);
		
		TipoNotificacion tipoNotificacion = (TipoNotificacion) notificacionDAO.obtener(notificacionDTO.getIdTipoNotificacion(), false);
		
		if(tipoNotificacion == null)
		{
			throw new NegocioException("Tipo de notificacion no encontrada");
		}
		
		Usuario usuario = (Usuario) usuarioDAO.obtener(notificacionDTO.getIdUsuario(), false);
		
		if(usuario == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		notificacion.setTipoNotificacion(tipoNotificacion);
		
		notificacion.setUsuario(usuario);
		
		notificacionDAO.insertar(notificacion);
		
		return notificacion.getId();
	}	
}