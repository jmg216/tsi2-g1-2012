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
  
  public com.geored.negocio.CheckInDTO[] obtenerListadoCheckIns() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerListadoCheckIns();
  }
  
  public void actualizar(com.geored.negocio.UsuarioDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    usuarioServiceImpl.actualizar(arg0);
  }
  
  public com.geored.negocio.UsuarioDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerListado();
  }
  
  public com.geored.negocio.UsuarioDTO obtenerPorEmailYPass(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtenerPorEmailYPass(arg0, arg1);
  }
  
  public void eliminar(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    usuarioServiceImpl.eliminar(arg0);
  }
  
  public java.lang.Long insertar(com.geored.negocio.UsuarioDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.insertar(arg0);
  }
  
  public com.geored.negocio.UsuarioDTO obtener(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (usuarioServiceImpl == null)
      _initUsuarioServiceImplProxy();
    return usuarioServiceImpl.obtener(arg0);
  }
  
  
}