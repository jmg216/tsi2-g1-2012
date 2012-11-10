/**
 * UsuarioServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class UsuarioServiceImplServiceLocator extends org.apache.axis.client.Service implements com.geored.negocio.UsuarioServiceImplService {

    public UsuarioServiceImplServiceLocator() {
    }


    public UsuarioServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UsuarioServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UsuarioServiceImplPort
    private java.lang.String UsuarioServiceImplPort_address = "http://localhost:8080/GeoRed-Business-EJB/UsuarioServiceImpl";

    public java.lang.String getUsuarioServiceImplPortAddress() {
        return UsuarioServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UsuarioServiceImplPortWSDDServiceName = "UsuarioServiceImplPort";

    public java.lang.String getUsuarioServiceImplPortWSDDServiceName() {
        return UsuarioServiceImplPortWSDDServiceName;
    }

    public void setUsuarioServiceImplPortWSDDServiceName(java.lang.String name) {
        UsuarioServiceImplPortWSDDServiceName = name;
    }

    public com.geored.negocio.UsuarioServiceImpl getUsuarioServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UsuarioServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUsuarioServiceImplPort(endpoint);
    }

    public com.geored.negocio.UsuarioServiceImpl getUsuarioServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.geored.negocio.UsuarioServiceImplServiceSoapBindingStub _stub = new com.geored.negocio.UsuarioServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUsuarioServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUsuarioServiceImplPortEndpointAddress(java.lang.String address) {
        UsuarioServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.geored.negocio.UsuarioServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.geored.negocio.UsuarioServiceImplServiceSoapBindingStub _stub = new com.geored.negocio.UsuarioServiceImplServiceSoapBindingStub(new java.net.URL(UsuarioServiceImplPort_address), this);
                _stub.setPortName(getUsuarioServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UsuarioServiceImplPort".equals(inputPortName)) {
            return getUsuarioServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://negocio.geored.com/", "UsuarioServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://negocio.geored.com/", "UsuarioServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UsuarioServiceImplPort".equals(portName)) {
            setUsuarioServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
