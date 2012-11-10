package com.geored.negocio;

public class CompraServiceImplProxy implements com.geored.negocio.CompraServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.CompraServiceImpl compraServiceImpl = null;
  
  public CompraServiceImplProxy() {
    _initCompraServiceImplProxy();
  }
  
  public CompraServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initCompraServiceImplProxy();
  }
  
  private void _initCompraServiceImplProxy() {
    try {
      compraServiceImpl = (new com.geored.negocio.CompraServiceImplServiceLocator()).getCompraServiceImplPort();
      if (compraServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)compraServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)compraServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (compraServiceImpl != null)
      ((javax.xml.rpc.Stub)compraServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.CompraServiceImpl getCompraServiceImpl() {
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl;
  }
  
  public void actualizar(com.geored.negocio.CompraDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    compraServiceImpl.actualizar(arg0);
  }
  
  public com.geored.negocio.CompraDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.obtenerListado();
  }
  
  public void eliminar(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    compraServiceImpl.eliminar(arg0);
  }
  
  public java.lang.Long insertar(com.geored.negocio.CompraDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.insertar(arg0);
  }
  
  public com.geored.negocio.CompraDTO obtener(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.obtener(arg0);
  }
  
  public com.geored.negocio.CompraDTO[] obtenerListadoPorOferta(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.obtenerListadoPorOferta(arg0);
  }
  
  
}