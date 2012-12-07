/**
 * EmpresaServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public interface EmpresaServiceImpl extends java.rmi.Remote {
    public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertarLocal(com.geored.negocio.LocalDTO localDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public void actualizar(com.geored.negocio.EmpresaDTO empresaDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.EmpresaDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public void eliminar(java.lang.Long idEmpres) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertar(com.geored.negocio.EmpresaDTO empresaDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public void actualizarLocal(com.geored.negocio.LocalDTO localDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.EmpresaDTO obtener(java.lang.Long idEmpresa) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.LocalDTO[] obtenerListadoLocales() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public void eliminarLocal(java.lang.Long idLocal) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.LocalDTO[] obtenerListadoLocalesPorEmpresa(java.lang.Long idEmpres) throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public com.geored.negocio.LocalDTO obtenerLocal(java.lang.Long idLocal) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.EmpresaDTO[] obtenerListadoPorAdministrador(java.lang.Long idAdministrador) throws java.rmi.RemoteException, com.geored.negocio.DaoException;
}
