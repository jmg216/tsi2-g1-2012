/**
 * CompraServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public interface CompraServiceImpl extends java.rmi.Remote {
    public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public void actualizar(com.geored.negocio.CompraDTO compraDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.CompraDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public com.geored.negocio.CompraDTO[] obtenerListadoPorOferta(java.lang.Long idOferta) throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public void eliminar(java.lang.Long idCompra) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertar(com.geored.negocio.CompraDTO compraDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.CompraDTO obtener(java.lang.Long idCompra) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
}
