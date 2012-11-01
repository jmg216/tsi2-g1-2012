/**
 * EmpresaServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class EmpresaServiceImplServiceLocator extends org.apache.axis.client.Service implements com.geored.negocio.EmpresaServiceImplService {

    public EmpresaServiceImplServiceLocator() {
    }


    public EmpresaServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmpresaServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmpresaServiceImplPort
    private java.lang.String EmpresaServiceImplPort_address = "http://localhost:8080/GeoRed-Business-EJB/EmpresaServiceImpl";

    public java.lang.String getEmpresaServiceImplPortAddress() {
        return EmpresaServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmpresaServiceImplPortWSDDServiceName = "EmpresaServiceImplPort";

    public java.lang.String getEmpresaServiceImplPortWSDDServiceName() {
        return EmpresaServiceImplPortWSDDServiceName;
    }

    public void setEmpresaServiceImplPortWSDDServiceName(java.lang.String name) {
        EmpresaServiceImplPortWSDDServiceName = name;
    }

    public com.geored.negocio.EmpresaServiceImpl getEmpresaServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmpresaServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmpresaServiceImplPort(endpoint);
    }

    public com.geored.negocio.EmpresaServiceImpl getEmpresaServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.geored.negocio.EmpresaServiceImplServiceSoapBindingStub _stub = new com.geored.negocio.EmpresaServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmpresaServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmpresaServiceImplPortEndpointAddress(java.lang.String address) {
        EmpresaServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.geored.negocio.EmpresaServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.geored.negocio.EmpresaServiceImplServiceSoapBindingStub _stub = new com.geored.negocio.EmpresaServiceImplServiceSoapBindingStub(new java.net.URL(EmpresaServiceImplPort_address), this);
                _stub.setPortName(getEmpresaServiceImplPortWSDDServiceName());
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
        if ("EmpresaServiceImplPort".equals(inputPortName)) {
            return getEmpresaServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://negocio.geored.com/", "EmpresaServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://negocio.geored.com/", "EmpresaServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmpresaServiceImplPort".equals(portName)) {
            setEmpresaServiceImplPortEndpointAddress(address);
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
