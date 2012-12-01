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
  
  public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.androidInvocation(methodName, methodParams);
  }
  
  public void actualizar(com.geored.negocio.CompraDTO compraDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    compraServiceImpl.actualizar(compraDTO);
  }
  
  public com.geored.negocio.CompraDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.obtenerListado();
  }
  
  public com.geored.negocio.CompraDTO[] obtenerListadoPorOferta(java.lang.Long idOferta) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.obtenerListadoPorOferta(idOferta);
  }
  
  public void eliminar(java.lang.Long idCompra) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    compraServiceImpl.eliminar(idCompra);
  }
  
  public java.lang.Long insertar(com.geored.negocio.CompraDTO compraDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.insertar(compraDTO);
  }
  
  public com.geored.negocio.CompraDTO obtener(java.lang.Long idCompra) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (compraServiceImpl == null)
      _initCompraServiceImplProxy();
    return compraServiceImpl.obtener(idCompra);
  }
  
  
}