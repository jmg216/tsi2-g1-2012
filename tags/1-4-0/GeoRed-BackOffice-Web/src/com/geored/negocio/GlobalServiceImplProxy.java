package com.geored.negocio;

public class GlobalServiceImplProxy implements com.geored.negocio.GlobalServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.GlobalServiceImpl globalServiceImpl = null;
  
  public GlobalServiceImplProxy() {
    _initGlobalServiceImplProxy();
  }
  
  public GlobalServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initGlobalServiceImplProxy();
  }
  
  private void _initGlobalServiceImplProxy() {
    try {
      globalServiceImpl = (new com.geored.negocio.GlobalServiceImplServiceLocator()).getGlobalServiceImplPort();
      if (globalServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)globalServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)globalServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (globalServiceImpl != null)
      ((javax.xml.rpc.Stub)globalServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.GlobalServiceImpl getGlobalServiceImpl() {
    if (globalServiceImpl == null)
      _initGlobalServiceImplProxy();
    return globalServiceImpl;
  }
  
  public com.geored.negocio.TematicaDTO[] obtenerListadoTematicas() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (globalServiceImpl == null)
      _initGlobalServiceImplProxy();
    return globalServiceImpl.obtenerListadoTematicas();
  }
  
  public com.geored.negocio.TipoAdministradorDTO[] obtenerListadoTiposAdministradores() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (globalServiceImpl == null)
      _initGlobalServiceImplProxy();
    return globalServiceImpl.obtenerListadoTiposAdministradores();
  }
  
  public com.geored.negocio.TipoNotificacionDTO[] obtenerListadoTiposNotificaciones() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (globalServiceImpl == null)
      _initGlobalServiceImplProxy();
    return globalServiceImpl.obtenerListadoTiposNotificaciones();
  }
  
  
}