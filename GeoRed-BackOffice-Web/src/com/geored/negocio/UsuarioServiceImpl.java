/**
 * UsuarioServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public interface UsuarioServiceImpl extends java.rmi.Remote {
    public com.geored.negocio.UsuarioDTO[] obtenerListadoAmigos(java.lang.Long idUsuario, boolean soloConectados) throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long enviarMensajeChat(com.geored.negocio.MensajeAmistadDTO mensajeAmistadDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.CheckInDTO[] obtenerListadoCheckIns() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public java.lang.Long insertarCheckIn(com.geored.negocio.CheckInDTO checkInDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.NotificacionDTO[] obtenerNotifsPorTipoYUsuarioDestino(java.lang.Long idTipoNotificacion, java.lang.Long idUsuarioDestino) throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public void actualizar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO obtenerPorEmailYPass(java.lang.String email, java.lang.String pass) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public void eliminar(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public void eliminarAmistad(java.lang.Long idAmistad) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.AmistadDTO obtenerAmistadPorUsuarios(java.lang.Long idUsuarioA, java.lang.Long idUsuarioB) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO obtener(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long enviarNotificacion(com.geored.negocio.NotificacionDTO notificacionDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertarAmistad(com.geored.negocio.AmistadDTO amistadDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertarNotificacion(com.geored.negocio.NotificacionDTO notificacionDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO[] obtenerListadoConectados() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
}
