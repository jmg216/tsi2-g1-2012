/**
 * GlobalServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public interface GlobalServiceImpl extends java.rmi.Remote {
    public com.geored.negocio.TematicaDTO[] obtenerListadoTematicas() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public com.geored.negocio.TipoAdministradorDTO[] obtenerListadoTiposAdministradores() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
    public com.geored.negocio.TipoNotificacionDTO[] obtenerListadoTiposNotificaciones() throws java.rmi.RemoteException, com.geored.negocio.DaoException;
}
