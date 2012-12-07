package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.AmistadDTO;
import com.geored.dto.CheckInDTO;
import com.geored.dto.MensajeAmistadDTO;
import com.geored.dto.NotificacionDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface UsuarioService
{
	// Metodo que atiende las solicitudes con contenido JSON, parsea e invoca el metodo correspondiente
	public String androidInvocation(String methodName, String methodParams) throws NegocioException, DaoException;
	
	public Long insertar(UsuarioDTO usuarioDTO)  throws NegocioException, DaoException;
	
	public void actualizar(UsuarioDTO usuarioDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idUsuario)  throws NegocioException, DaoException;
	
	public UsuarioDTO obtener(Long idUsuario)  throws NegocioException, DaoException;
	
	public List<UsuarioDTO> obtenerListado() throws DaoException;
	
	public List<UsuarioDTO> obtenerListadoConectados() throws DaoException;
	
	public UsuarioDTO obtenerPorEmailYPass(String email, String pass) throws NegocioException, DaoException;
	
	// OPERACIONES CON CHECK-INS
	public List<CheckInDTO> obtenerListadoCheckIns() throws DaoException;
	
	// OPERACIONES MENSAJES Y NOTIFICACIONES
	public Long enviarMensajeChat(MensajeAmistadDTO mensajeAmistadDTO) throws NegocioException, DaoException;
	
	public Long enviarNotificacion(NotificacionDTO notificacionDTO) throws NegocioException, DaoException;
	
	public List<NotificacionDTO> obtenerListadoPorTipoYUsuarioDestino(Long idTipoNotificacion, Long idUsuarioDestino) throws DaoException;
	
	// OPERACIONES CON AMISTADES
	public List<UsuarioDTO> obtenerListadoAmigos(Long idUsuario, boolean soloConectados) throws DaoException;
	
	public AmistadDTO obtenerAmistadPorUsuarios(Long idUsuarioA, Long idUsuariOB) throws NegocioException, DaoException;
	
	public Long insertarAmistad(AmistadDTO amistadDTO) throws NegocioException, DaoException;
	
	public void eliminarAmistad(Long idAmistad) throws NegocioException, DaoException;
}