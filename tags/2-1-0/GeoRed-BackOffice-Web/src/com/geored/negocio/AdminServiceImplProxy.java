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
  
  public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.androidInvocation(methodName, methodParams);
  }
  
  public void actualizar(com.geored.negocio.AdministradorDTO administradorDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    adminServiceImpl.actualizar(administradorDTO);
  }
  
  public com.geored.negocio.AdministradorDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtenerListado();
  }
  
  public com.geored.negocio.AdministradorDTO[] obtenerListadoPorTipo(java.lang.Long idTipoAdmin) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtenerListadoPorTipo(idTipoAdmin);
  }
  
  public void eliminar(java.lang.Long idAdministrador) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    adminServiceImpl.eliminar(idAdministrador);
  }
  
  public java.lang.Long insertar(com.geored.negocio.AdministradorDTO administradorDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.insertar(administradorDTO);
  }
  
  public com.geored.negocio.AdministradorDTO obtener(java.lang.Long idAdministrador) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtener(idAdministrador);
  }
  
  public com.geored.negocio.AdministradorDTO obtenerAdminPorEmailYPass(java.lang.String email, java.lang.String pass) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (adminServiceImpl == null)
      _initAdminServiceImplProxy();
    return adminServiceImpl.obtenerAdminPorEmailYPass(email, pass);
  }
  
  
}