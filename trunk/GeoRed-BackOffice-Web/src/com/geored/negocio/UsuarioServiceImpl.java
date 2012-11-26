/**
 * UsuarioServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public interface UsuarioServiceImpl extends java.rmi.Remote {
    public com.geored.negocio.CheckInDTO[] obtenerListadoCheckIns() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public void actualizar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO obtenerPorEmailYPass(java.lang.String email, java.lang.String pass) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public void eliminar(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.UsuarioDTO obtener(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
}
