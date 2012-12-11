package com.geored.negocio;

public class UsuarioServiceImplProxy implements com.geored.negocio.UsuarioServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.UsuarioServiceImpl usuarioServiceImpl = null;
  
  public UsuarioServiceImplProxy() {
    _initUsuarioServiceImplProxy();
  }
  
  public UsuarioServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsuarioServiceImplProxy();
  }
  
  private void _initUsuarioServiceImplProxy() {
    try {
      usuarioServiceImpl = (new com.geored.negocio.UsuarioServiceImplServiceLocator()).getUsuarioServiceImplPort();
      if (usuarioServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usuarioServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usuarioServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usuarioServiceImpl != null)
      ((javax.xml.rpc.Stub)usuarioServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.UsuarioServiceImpl getUsuarioServiceImpl() {
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl;
  }
  
  public com.geored.negocio.UsuarioDTO[] obtenerListadoAmigos(java.lang.Long idUsuario, boolean soloConectados) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerListadoAmigos(idUsuario, soloConectados);
  }
  
  public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.androidInvocation(methodName, methodParams);
  }
  
  public java.lang.Long enviarMensajeChat(com.geored.negocio.MensajeAmistadDTO mensajeAmistadDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.enviarMensajeChat(mensajeAmistadDTO);
  }
  
  public com.geored.negocio.CheckInDTO[] obtenerListadoCheckIns() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerListadoCheckIns();
  }
  
  public java.lang.Long insertarCheckIn(com.geored.negocio.CheckInDTO checkInDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.insertarCheckIn(checkInDTO);
  }
  
  public com.geored.negocio.NotificacionDTO[] obtenerNotifsPorTipoYUsuarioDestino(java.lang.Long idTipoNotificacion, java.lang.Long idUsuarioDestino) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerNotifsPorTipoYUsuarioDestino(idTipoNotificacion, idUsuarioDestino);
  }
  
  public void actualizar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    usuarioServiceImpl.actualizar(usuarioDTO);
  }
  
  public com.geored.negocio.UsuarioDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerListado();
  }
  
  public com.geored.negocio.UsuarioDTO obtenerPorEmailYPass(java.lang.String email, java.lang.String pass) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerPorEmailYPass(email, pass);
  }
  
  public void eliminar(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    usuarioServiceImpl.eliminar(idUsuario);
  }
  
  public java.lang.Long insertar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.insertar(usuarioDTO);
  }
  
  public void eliminarAmistad(java.lang.Long idAmistad) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    usuarioServiceImpl.eliminarAmistad(idAmistad);
  }
  
  public com.geored.negocio.AmistadDTO obtenerAmistadPorUsuarios(java.lang.Long idUsuarioA, java.lang.Long idUsuarioB) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerAmistadPorUsuarios(idUsuarioA, idUsuarioB);
  }
  
  public com.geored.negocio.UsuarioDTO obtener(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtener(idUsuario);
  }
  
  public java.lang.Long enviarNotificacion(com.geored.negocio.NotificacionDTO notificacionDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.enviarNotificacion(notificacionDTO);
  }
  
  public java.lang.Long insertarAmistad(com.geored.negocio.AmistadDTO amistadDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.insertarAmistad(amistadDTO);
  }
  
  public java.lang.Long insertarNotificacion(com.geored.negocio.NotificacionDTO notificacionDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.insertarNotificacion(notificacionDTO);
  }
  
  public com.geored.negocio.UsuarioDTO[] obtenerListadoConectados() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerListadoConectados();
  }
  
  
}