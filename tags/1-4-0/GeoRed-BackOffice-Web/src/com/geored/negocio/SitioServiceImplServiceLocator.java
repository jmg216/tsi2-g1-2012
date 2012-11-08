/**
 * SitioServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class SitioServiceImplServiceLocator extends org.apache.axis.client.Service implements com.geored.negocio.SitioServiceImplService {

    public SitioServiceImplServiceLocator() {
    }


    public SitioServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SitioServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SitioServiceImplPort
    private java.lang.String SitioServiceImplPort_address = "http://localhost:8080/GeoRed-Business-EJB/SitioServiceImpl";

    public java.lang.String getSitioServiceImplPortAddress() {
        return SitioServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SitioServiceImplPortWSDDServiceName = "SitioServiceImplPort";

    public java.lang.String getSitioServiceImplPortWSDDServiceName() {
        return SitioServiceImplPortWSDDServiceName;
    }

    public void setSitioServiceImplPortWSDDServiceName(java.lang.String name) {
        SitioServiceImplPortWSDDServiceName = name;
    }

    public com.geored.negocio.SitioServiceImpl getSitioServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SitioServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSitioServiceImplPort(endpoint);
    }

    public com.geored.negocio.SitioServiceImpl getSitioServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.geored.negocio.SitioServiceImplServiceSoapBindingStub _stub = new com.geored.negocio.SitioServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSitioServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSitioServiceImplPortEndpointAddress(java.lang.String address) {
        SitioServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.geored.negocio.SitioServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.geored.negocio.SitioServiceImplServiceSoapBindingStub _stub = new com.geored.negocio.SitioServiceImplServiceSoapBindingStub(new java.net.URL(SitioServiceImplPort_address), this);
                _stub.setPortName(getSitioServiceImplPortWSDDServiceName());
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
        if ("SitioServiceImplPort".equals(inputPortName)) {
            return getSitioServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://negocio.geored.com/", "SitioServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://negocio.geored.com/", "SitioServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SitioServiceImplPort".equals(portName)) {
            setSitioServiceImplPortEndpointAddress(address);
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
