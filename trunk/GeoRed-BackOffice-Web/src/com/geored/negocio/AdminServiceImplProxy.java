package com.geored.negocio;

public class AdminServiceImplProxy implements com.geored.negocio.AdminServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.AdminServiceImpl adminServiceImpl = null;
  
  public AdminServiceImplProxy() {
    _initAdminServiceImplProxy();
  }
  
  public AdminServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initAdminServiceImplProxy();
  }
  
  private void _initAdminServiceImplProxy() {
    try {
      adminServiceImpl = (new com.geored.negocio.AdminServiceImplServiceLocator()).getAdminServiceImplPort();
      if (adminServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)adminServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)adminServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (adminServiceImpl != null)
      ((javax.xml.rpc.Stub)adminServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.AdminServiceImpl getAdminServiceImpl() {
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl;
  }
  
  public void actualizar(com.geored.negocio.AdministradorDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    adminServiceImpl.actualizar(arg0);
  }
  
  public com.geored.negocio.AdministradorDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtenerListado();
  }
  
  public com.geored.negocio.AdministradorDTO[] obtenerListadoPorTipo(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtenerListadoPorTipo(arg0);
  }
  
  public void eliminar(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    adminServiceImpl.eliminar(arg0);
  }
  
  public java.lang.Long insertar(com.geored.negocio.AdministradorDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.insertar(arg0);
  }
  
  public com.geored.negocio.AdministradorDTO obtener(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtener(arg0);
  }
  
  public com.geored.negocio.AdministradorDTO obtenerAdminPorEmailYPass(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtenerAdminPorEmailYPass(arg0, arg1);
  }
  
  
}