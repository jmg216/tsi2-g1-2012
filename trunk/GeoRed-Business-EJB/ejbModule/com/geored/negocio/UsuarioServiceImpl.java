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
	
	@WebMethod(operationName="androidInvocation")
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
		else if(methodName.equals("enviarNotificacion"))
		{
			NotificacionDTO notificacionDTO = (NotificacionDTO) params.getParam("notificacionDTO", NotificacionDTO.class);
			
			Long idNotificacion = enviarNotificacion(notificacionDTO);
			
			return new Gson().toJson(idNotificacion);
		}
		else if(methodName.equals("obtenerListadoPorTipoYUsuarioDestino"))
		{
			Long idTipoNotificacion = (Long) params.getParam("idTipoNotificacion", Long.class);
			Long idUsuarioDestino = (Long) params.getParam("idUsuarioDestino", Long.class);
			
			return new Gson().toJson(obtenerListadoPorTipoYUsuarioDestino(idTipoNotificacion, idUsuarioDestino));
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
		
		mensajeAmistad = mensajeAmistadDAO.insertar(mensajeAmistad);
		
		mensajeAmistadDTO = mensajeAmistadDAO.toDto(mensajeAmistad);
		
		Long idDestinatario = amistad.getUsuarioA().getId();
		
		UsuarioDTO usuario = obtener(idDestinatario);
		
		List<String> androidTargets = new ArrayList<String>();
		androidTargets.add(usuario.getGcmRegId());
		
		AndroidGCMPushNotification.enviarMensajeChatGCM("10", androidTargets, mensajeAmistadDTO);
		
		return mensajeAmistad.getId();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="enviarNotificacion")
	public Long enviarNotificacion(@WebParam(name="notificacionDTO") NotificacionDTO notificacionDTO) throws NegocioException, DaoException
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
		
		notificacionDTO.setId(notificacion.getId());
		
		List<String> androidTargets = new ArrayList<String>();
		androidTargets.add(usuarioDestino.getGcmRegId());
		AndroidGCMPushNotification.enviarNotificaciones("10", androidTargets, notificacionDTO);		
		
		return notificacion.getId();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerListadoConectados")
	public List<UsuarioDTO> obtenerListadoConectados() throws DaoException
	{
		return usuarioDAO.obtenerListadoConectados(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerListadoAmigos")
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
	@WebMethod(operationName="obtenerAmistadPorUsuarios")
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
	@WebMethod(operationName="insertarAmistad")
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
	@WebMethod(operationName="eliminarAmistad")
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
	@WebMethod(operationName="obtenerListadoPorTipoYUsuarioDestino")
	public List<NotificacionDTO> obtenerListadoPorTipoYUsuarioDestino(@WebParam(name="idTipoNotificacion") Long idTipoNotificacion, @WebParam(name="idUsuarioDestino") Long idUsuarioDestino) throws DaoException
	{
		return notificacionDAO.obtenerListadoPorTipoYUsuarioDestino(idTipoNotificacion, idUsuarioDestino, true);
	}

	@Override
	public Long insertarCheckIn(CheckInDTO checkInDTO) throws NegocioException, DaoException
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
			Notificacion notificacion = new Notificacion();
			
			notificacion.setDescripcion(usuarioCheckIn.getNombre() + " ha hecho checkin en " + sitio.getNombre());
			
			notificacion.setLeida(false);
			
			notificacion.setTipoNotificacion((TipoNotificacion) tipoNotificacionDAO.obtener(ConstantesGenerales.TiposNotificacion.ID_CHECKIN_AMIGO, false));
			
			notificacion.setUsuarioDestino((Usuario) usuarioDAO.obtener(usuarioDTO.getId(), false));
			
			notificacion.setMetadataNotif(usuarioDTO.getId().toString() + ";" + sitio.getId().toString());
			
			notificacionDAO.insertar(notificacion);
			
			// Si el usaurio destino tiene el gcm reg id envio al movil
			if(!UtilesNegocio.isNullOrEmpty(usuarioDTO.getGcmRegId()))
			{
				List<String> androidTargets = new ArrayList<String>();
				
				androidTargets.add(usuarioDTO.getGcmRegId());
				
				AndroidGCMPushNotification.enviarNotificaciones("10", androidTargets, notificacionDAO.toDto(notificacion));
			}
		}
		
		return checkInEntity.getId();
	}			
}