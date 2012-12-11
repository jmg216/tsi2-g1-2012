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
import com.geored.dominio.CheckIn;
import com.geored.dominio.MensajeAmistad;
import com.geored.dominio.Notificacion;
import com.geored.dominio.Sitio;
import com.geored.dominio.Tematica;
import com.geored.dominio.TipoNotificacion;
import com.geored.dominio.Usuario;
import com.geored.dto.AmistadDTO;
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
import com.geored.persistencia.SitioDAO;
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
	
	@EJB
	private SitioDAO sitioDAO;
	
	@WebMethod
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("insertar"))
		{		
			UsuarioDTO usuarioDTO = (UsuarioDTO) params.getParam("usuarioDTO", UsuarioDTO.class);
			
			Long idUsuario = insertar((UsuarioDTO) usuarioDTO);
			
			return new Gson().toJson(idUsuario);
		}
		else if(methodName.equals("actualizar"))
		{
			UsuarioDTO usuarioDTO = (UsuarioDTO) params.getParam("usuarioDTO", UsuarioDTO.class);
			
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
		else if(methodName.equals("insertarCheckin"))
		{
			CheckInDTO checkInDTO = (CheckInDTO) params.getParam("checkInDTO", CheckInDTO.class);
			
			return new Gson().toJson(insertarCheckIn(checkInDTO));
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
		else if(methodName.equals("insertarNotificacion"))
		{
			NotificacionDTO notificacionDTO = (NotificacionDTO) params.getParam("notificacionDTO", NotificacionDTO.class);
			
			Long idNotificacion = insertarNotificacion(notificacionDTO);
			
			return new Gson().toJson(idNotificacion);
		}
		else if(methodName.equals("aceptarNotificacion"))
		{
			Long idNotificacion = (Long) params.getParam("idNotificacion", Long.class);
			
			aceptarNotificacion(idNotificacion);
		}
		else if(methodName.equals("enviarNotificacion"))
		{
			NotificacionDTO notificacionDTO = (NotificacionDTO) params.getParam("notificacionDTO", NotificacionDTO.class);
			
			Long idNotificacion = enviarNotificacion(notificacionDTO);
			
			return new Gson().toJson(idNotificacion);
		}
		else if(methodName.equals("obtenerNotifsPorTipoYUsuarioDestino"))
		{
			Long idTipoNotificacion = (Long) params.getParam("idTipoNotificacion", Long.class);
			Long idUsuarioDestino = (Long) params.getParam("idUsuarioDestino", Long.class);
			
			return new Gson().toJson(obtenerNotifsPorTipoYUsuarioDestino(idTipoNotificacion, idUsuarioDestino));
		}
		else if(methodName.equals("obtenerListadoConectados"))
		{	
			return new Gson().toJson(obtenerListadoConectados());
		}
		else if(methodName.equals("obtenerListadoAmigos"))
		{	
			Long idUsuario = (Long) params.getParam("idUsuario", Long.class);
			Boolean soloConectados = (Boolean) params.getParam("soloConectados", Boolean.class);
			
			return new Gson().toJson(obtenerListadoAmigos(idUsuario, soloConectados));
		}
		else if (methodName.equals("obtenerAmistadPorUsuarios"))
		{
			Long idUsuarioA = (Long) params.getParam("idUsuarioA", Long.class);
			Long idUsuarioB = (Long) params.getParam("idUsuarioB", Long.class);
			
			return new Gson().toJson(obtenerAmistadPorUsuarios(idUsuarioA, idUsuarioB));
		}		
		else if (methodName.equals("insertarAmistad"))
		{
			AmistadDTO amistadDTO = (AmistadDTO) params.getParam("amistadDTO", AmistadDTO.class);
			
			return new Gson().toJson(insertarAmistad(amistadDTO));
		}
		else if (methodName.equals("eliminarAmistad"))
		{
			Long idAmistad = (Long) params.getParam("idAmistad", Long.class);
			
			eliminarAmistad(idAmistad);
		}
	
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
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
	@WebMethod
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
			throw new NegocioException("Usuario no encontrada");
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
	@WebMethod
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
	@WebMethod
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
	@WebMethod
	public List<UsuarioDTO> obtenerListado() throws DaoException
	{
		return usuarioDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public UsuarioDTO obtenerPorEmailYPass(@WebParam(name="email") String email, @WebParam(name="pass") String pass) throws NegocioException, DaoException
	{
		UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtenerUsuarioPorEmailYPass(email, pass, true);
		
		if(usuarioDTO == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		return usuarioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<CheckInDTO> obtenerListadoCheckIns() throws DaoException
	{
		return checkInDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
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
		
		// Envio el mensaje al movil
		mensajeAmistadDTO = mensajeAmistadDAO.toDto(mensajeAmistad);
		
		Long idDestinatario = amistad.getUsuarioA().getId().equals(remitente.getId()) ? amistad.getUsuarioB().getId() : amistad.getUsuarioA().getId();
		
		UsuarioDTO usuarioDestinatarioDTO = obtener(idDestinatario);
		
		List<String> androidTargets = new ArrayList<String>();
		
		androidTargets.add(usuarioDestinatarioDTO.getGcmRegId());
		
		AndroidGCMPushNotification.enviarMensajeChatGCM(androidTargets, mensajeAmistadDTO);
		
		return mensajeAmistad.getId();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public Long enviarNotificacion(@WebParam(name="notificacionDTO") NotificacionDTO notificacionDTO) throws NegocioException, DaoException
	{
		Usuario usuarioDestino = (Usuario) usuarioDAO.obtener(notificacionDTO.getIdUsuarioDestino(), false);
		
		if(!UtilesNegocio.isNullOrEmpty(usuarioDestino.getGcmRegId()))
		{
			// Inserto la notificacion en la BD
			notificacionDTO.setId(insertarNotificacion(notificacionDTO));
			
			// Envio la notificacion al movil		
			List<String> androidTargets = new ArrayList<String>();
			
			androidTargets.add(usuarioDestino.getGcmRegId());
			
			AndroidGCMPushNotification.enviarNotificaciones(androidTargets, notificacionDTO);		
			
			return notificacionDTO.getId();
		}


		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<UsuarioDTO> obtenerListadoConectados() throws DaoException
	{
		return usuarioDAO.obtenerListadoConectados(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<UsuarioDTO> obtenerListadoAmigos(@WebParam(name="idUsuario") Long idUsuario, @WebParam(name="soloConectados") boolean soloConectados) throws DaoException
	{
		List<UsuarioDTO> usuariosDTOamigos = new ArrayList<>();
		
		List<Amistad> amistades = amistadDAO.obtenerAmistadesUsuario(idUsuario, soloConectados, false);
		
		if(amistades != null)
		{
			for(Amistad amistad : amistades)
			{
				if(amistad.getUsuarioA().getId().equals(idUsuario))
				{
					usuariosDTOamigos.add(usuarioDAO.toDto(amistad.getUsuarioA()));
				}
				else
				{
					usuariosDTOamigos.add(usuarioDAO.toDto(amistad.getUsuarioB()));	
				}
			}
		}
		
		return usuariosDTOamigos;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public AmistadDTO obtenerAmistadPorUsuarios(@WebParam(name="idUsuarioA") Long idUsuarioA, @WebParam(name="idUsuarioB") Long idUsuarioB) throws NegocioException, DaoException
	{		
		AmistadDTO amistadDTO = (AmistadDTO) amistadDAO.obtenerAmistadPorUsuarios(idUsuarioA, idUsuarioB, true);
		
		if(amistadDTO == null)
		{
			throw new NegocioException("Amistad no encontrada");
		}
		
		return amistadDTO;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertarAmistad(@WebParam(name="amistadDTO") AmistadDTO amistadDTO) throws NegocioException, DaoException
	{
		Amistad amistad = amistadDAO.toEntity(amistadDTO);
		
		Usuario usuarioA = (Usuario) usuarioDAO.obtener(amistadDTO.getIdUsuarioA(), true);
		
		Usuario usuarioB = (Usuario) usuarioDAO.obtener(amistadDTO.getIdUsuarioB(), true);
		
		if(usuarioA == null || usuarioB == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		amistad.setUsuarioA(usuarioA);
		
		amistad.setUsuarioB(usuarioB);
		
		amistadDAO.insertar(amistad);
		
		return amistad.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminarAmistad(@WebParam(name="idAmistad") Long idAmistad) throws NegocioException, DaoException
	{
		Amistad amistad = (Amistad) amistadDAO.obtener(idAmistad, false);
		
		if(amistad == null)
		{
			throw new NegocioException("Amistad no encontrada");
		}
		
		amistadDAO.eliminar(amistad);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public List<NotificacionDTO> obtenerNotifsPorTipoYUsuarioDestino(@WebParam(name="idTipoNotificacion") Long idTipoNotificacion, @WebParam(name="idUsuarioDestino") Long idUsuarioDestino) throws DaoException
	{
		return notificacionDAO.obtenerListadoPorTipoYUsuarioDestino(idTipoNotificacion, idUsuarioDestino, true);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertarCheckIn(@WebParam(name="checkInDTO") CheckInDTO checkInDTO) throws NegocioException, DaoException
	{
		CheckIn checkInEntity = checkInDAO.toEntity(checkInDTO);
		
		Sitio sitio = (Sitio) sitioDAO.obtener(checkInDTO.getIdSitio(), false);
		
		if(sitio == null)
		{
			throw new NegocioException("Sitio no encontrado");
		}
		
		Usuario usuarioCheckIn = (Usuario) usuarioDAO.obtener(checkInDTO.getIdUsuario(), false);
		
		if(usuarioCheckIn == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
 		
		checkInEntity.setSitio(sitio);
		
		checkInEntity.setUsuario(usuarioCheckIn);
		
		checkInDAO.insertar(checkInEntity);
		
		// Notifico a mis amigos hice checkin
		List<UsuarioDTO> listadoAmigosDTO = obtenerListadoAmigos(usuarioCheckIn.getId(), false);
		
		for(UsuarioDTO usuarioDTO : listadoAmigosDTO)
		{
			// Si el usaurio destino tiene el gcm reg id envio al movil
			if(!UtilesNegocio.isNullOrEmpty(usuarioDTO.getGcmRegId()))
			{
				NotificacionDTO notificacionDTO = new NotificacionDTO();
				
				notificacionDTO.setDescripcion(usuarioCheckIn.getNombre() + " ha hecho checkin en " + sitio.getNombre());
				
				notificacionDTO.setLeida(false);
				
				notificacionDTO.setIdTipoNotificacion(ConstantesGenerales.TiposNotificacion.ID_CHECKIN_AMIGO);
				
				notificacionDTO.setIdUsuarioDestino(usuarioDTO.getId());
				
				notificacionDTO.setMetadataNotif(usuarioDTO.getId().toString() + ";" + sitio.getUbicacionGeografica());
			
				// Envio a GCM
				List<String> androidTargets = new ArrayList<String>();
				
				androidTargets.add(usuarioDTO.getGcmRegId());
				
				AndroidGCMPushNotification.enviarNotificaciones(androidTargets, notificacionDTO);
			}
		}
		
		return checkInEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertarNotificacion(@WebParam(name="notificacionDTO") NotificacionDTO notificacionDTO) throws NegocioException, DaoException
	{
		Notificacion notificacion = notificacionDAO.toEntity(notificacionDTO);
		
		TipoNotificacion tipoNotificacion = (TipoNotificacion) tipoNotificacionDAO.obtener(notificacionDTO.getIdTipoNotificacion(), false);
		
		if(tipoNotificacion == null)
		{
			throw new NegocioException("Tipo de notificacion no encontrada");
		}
		
		Usuario usuarioDestino = (Usuario) usuarioDAO.obtener(notificacionDTO.getIdUsuarioDestino(), false);
		
		if(usuarioDestino == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		notificacion.setTipoNotificacion(tipoNotificacion);
		
		notificacion.setUsuarioDestino(usuarioDestino);
		
		notificacionDAO.insertar(notificacion);
		
		return notificacion.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void aceptarNotificacion(Long idNotificacion) throws NegocioException, DaoException
	{
		Notificacion notificacionEntity = (Notificacion) notificacionDAO.obtener(idNotificacion, false);
		
		if(notificacionEntity == null)
		{
			throw new NegocioException("Notificacion no encontrada");
		}
		
		if(notificacionEntity.getTipoNotificacion().getId().equals(ConstantesGenerales.TiposNotificacion.ID_SOLICITUD_AMISTAD))
		{
			Amistad amistadEntity = new Amistad();
			
			Usuario usuarioA = (Usuario) usuarioDAO.obtener(Long.valueOf(notificacionEntity.getMetadataNotif()), false);
			
			if(usuarioA == null)
			{
				throw new NegocioException("Usuario no encontrado");
			}
			
			amistadEntity.setUsuarioA(usuarioA);
			
			amistadEntity.setUsuarioB(notificacionEntity.getUsuarioDestino());
			
			amistadDAO.insertar(amistadEntity);
		}
		
		notificacionEntity.setLeida(true);
		
		notificacionDAO.actualizar(notificacionEntity);
		
	}			
}