package com.geored.negocio;

public class EmpresaServiceImplProxy implements com.geored.negocio.EmpresaServiceImpl {
  private String _endpoint = null;
  private com.geored.negocio.EmpresaServiceImpl empresaServiceImpl = null;
  
  public EmpresaServiceImplProxy() {
    _initEmpresaServiceImplProxy();
  }
  
  public EmpresaServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmpresaServiceImplProxy();
  }
  
  private void _initEmpresaServiceImplProxy() {
    try {
      empresaServiceImpl = (new com.geored.negocio.EmpresaServiceImplServiceLocator()).getEmpresaServiceImplPort();
      if (empresaServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)empresaServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)empresaServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (empresaServiceImpl != null)
      ((javax.xml.rpc.Stub)empresaServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.geored.negocio.EmpresaServiceImpl getEmpresaServiceImpl() {
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl;
  }
  
  public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.androidInvocation(methodName, methodParams);
  }
  
  public java.lang.Long insertarLocal(com.geored.negocio.LocalDTO localDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.insertarLocal(localDTO);
  }
  
  public void actualizar(com.geored.negocio.EmpresaDTO empresaDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    empresaServiceImpl.actualizar(empresaDTO);
  }
  
  public com.geored.negocio.EmpresaDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.obtenerListado();
  }
  
  public void eliminar(java.lang.Long idEmpres) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    empresaServiceImpl.eliminar(idEmpres);
  }
  
  public java.lang.Long insertar(com.geored.negocio.EmpresaDTO empresaDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.insertar(empresaDTO);
  }
  
  public void actualizarLocal(com.geored.negocio.LocalDTO localDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    empresaServiceImpl.actualizarLocal(localDTO);
  }
  
  public com.geored.negocio.EmpresaDTO obtener(java.lang.Long idEmpresa) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.obtener(idEmpresa);
  }
  
  public com.geored.negocio.LocalDTO[] obtenerListadoLocales() throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.obtenerListadoLocales();
  }
  
  public void eliminarLocal(java.lang.Long idLocal) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    empresaServiceImpl.eliminarLocal(idLocal);
  }
  
  public com.geored.negocio.LocalDTO[] obtenerListadoLocalesPorEmpresa(java.lang.Long idEmpres) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.obtenerListadoLocalesPorEmpresa(idEmpres);
  }
  
  public com.geored.negocio.LocalDTO obtenerLocal(java.lang.Long idLocal) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.obtenerLocal(idLocal);
  }
  
  public com.geored.negocio.EmpresaDTO[] obtenerListadoPorAdministrador(java.lang.Long idAdministrador) throws java.rmi.RemoteException, com.geored.negocio.DaoException{
    if (empresaServiceImpl == null)
      _initEmpresaServiceImplProxy();
    return empresaServiceImpl.obtenerListadoPorAdministrador(idAdministrador);
  }
  
  
}