package com.geored.negocio;

public class EventoServiceImplProxy implements com.geored.negocio.EventoServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.EventoServiceImpl eventoServiceImpl = null;
  
  public EventoServiceImplProxy() {
    _initEventoServiceImplProxy();
  }
  
  public EventoServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initEventoServiceImplProxy();
  }
  
  private void _initEventoServiceImplProxy() {
    try {
      eventoServiceImpl = (new com.geored.negocio.EventoServiceImplServiceLocator()).getEventoServiceImplPort();
      if (eventoServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eventoServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eventoServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eventoServiceImpl != null)
      ((javax.xml.rpc.Stub)eventoServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.EventoServiceImpl getEventoServiceImpl() {
    if (eventoServiceImpl == null)
      _initEventoServiceImplProxy();
    return eventoServiceImpl;
  }
  
  public void actualizar(com.geored.negocio.EventoDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (eventoServiceImpl == null)
      _initEventoServiceImplProxy();
    eventoServiceImpl.actualizar(arg0);
  }
  
  public com.geored.negocio.EventoDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (eventoServiceImpl == null)
      _initEventoServiceImplProxy();
    return eventoServiceImpl.obtenerListado();
  }
  
  public void eliminar(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (eventoServiceImpl == null)
      _initEventoServiceImplProxy();
    eventoServiceImpl.eliminar(arg0);
  }
  
  public java.lang.Long insertar(com.geored.negocio.EventoDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (eventoServiceImpl == null)
      _initEventoServiceImplProxy();
    return eventoServiceImpl.insertar(arg0);
  }
  
  public com.geored.negocio.EventoDTO obtener(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (eventoServiceImpl == null)
      _initEventoServiceImplProxy();
    return eventoServiceImpl.obtener(arg0);
  }
  
  
}