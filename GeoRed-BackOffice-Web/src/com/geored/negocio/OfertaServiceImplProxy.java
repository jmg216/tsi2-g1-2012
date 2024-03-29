package com.geored.negocio;

public class OfertaServiceImplProxy implements com.geored.negocio.OfertaServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.OfertaServiceImpl ofertaServiceImpl = null;
  
  public OfertaServiceImplProxy() {
    _initOfertaServiceImplProxy();
  }
  
  public OfertaServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initOfertaServiceImplProxy();
  }
  
  private void _initOfertaServiceImplProxy() {
    try {
      ofertaServiceImpl = (new com.geored.negocio.OfertaServiceImplServiceLocator()).getOfertaServiceImplPort();
      if (ofertaServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ofertaServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ofertaServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ofertaServiceImpl != null)
      ((javax.xml.rpc.Stub)ofertaServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.OfertaServiceImpl getOfertaServiceImpl() {
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    return ofertaServiceImpl;
  }
  
  public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    return ofertaServiceImpl.androidInvocation(methodName, methodParams);
  }
  
  public void actualizar(com.geored.negocio.OfertaDTO ofertaDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    ofertaServiceImpl.actualizar(ofertaDTO);
  }
  
  public com.geored.negocio.OfertaDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    return ofertaServiceImpl.obtenerListado();
  }
  
  public void eliminar(java.lang.Long idOferta) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    ofertaServiceImpl.eliminar(idOferta);
  }
  
  public java.lang.Long insertar(com.geored.negocio.OfertaDTO ofertaDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    return ofertaServiceImpl.insertar(ofertaDTO);
  }
  
  public com.geored.negocio.OfertaDTO[] obtenerListadoPorEmpresa(java.lang.Long idEmpresa) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    return ofertaServiceImpl.obtenerListadoPorEmpresa(idEmpresa);
  }
  
  public com.geored.negocio.OfertaDTO obtener(java.lang.Long idOferta) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (ofertaServiceImpl == null)
      _initOfertaServiceImplProxy();
    return ofertaServiceImpl.obtener(idOferta);
  }
  
  
}