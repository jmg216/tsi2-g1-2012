/**
 * EventoServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public interface EventoServiceImpl extends java.rmi.Remote {
    public void actualizar(com.geored.negocio.EventoDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.EventoDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public void eliminar(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public java.lang.Long insertar(com.geored.negocio.EventoDTO arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
    public com.geored.negocio.EventoDTO obtener(java.lang.Long arg0) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException;
}
