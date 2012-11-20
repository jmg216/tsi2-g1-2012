package com.geored.negocio;

public class SitioServiceImplProxy implements com.geored.negocio.SitioServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.SitioServiceImpl sitioServiceImpl = null;
  
  public SitioServiceImplProxy() {
    _initSitioServiceImplProxy();
  }
  
  public SitioServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initSitioServiceImplProxy();
  }
  
  private void _initSitioServiceImplProxy() {
    try {
      sitioServiceImpl = (new com.geored.negocio.SitioServiceImplServiceLocator()).getSitioServiceImplPort();
      if (sitioServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sitioServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sitioServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sitioServiceImpl != null)
      ((javax.xml.rpc.Stub)sitioServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.SitioServiceImpl getSitioServiceImpl() {
    if (sitioServiceImpl == null)
      _initSitioServiceImplProxy();
    return sitioServiceImpl;
  }
  
  public void actualizar(com.geored.negocio.SitioDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (sitioServiceImpl == null)
      _initSitioServiceImplProxy();
    sitioServiceImpl.actualizar(arg0);
  }
  
  public com.geored.negocio.SitioDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (sitioServiceImpl == null)
      _initSitioServiceImplProxy();
    return sitioServiceImpl.obtenerListado();
  }
  
  public void eliminar(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (sitioServiceImpl == null)
      _initSitioServiceImplProxy();
    sitioServiceImpl.eliminar(arg0);
  }
  
  public java.lang.Long insertar(com.geored.negocio.SitioDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (sitioServiceImpl == null)
      _initSitioServiceImplProxy();
    return sitioServiceImpl.insertar(arg0);
  }
  
  public com.geored.negocio.SitioDTO obtener(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (sitioServiceImpl == null)
      _initSitioServiceImplProxy();
    return sitioServiceImpl.obtener(arg0);
  }
  
  
}