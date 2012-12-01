/**
 * UsuarioServiceImplServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class UsuarioServiceImplServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.geored.negocio.UsuarioServiceImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("androidInvocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "methodName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "methodParams"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarMensajeChat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mensajeAmistadDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://negocio.geored.com/", "mensajeAmistadDTO"), com.geored.negocio.MensajeAmistadDTO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerListadoCheckIns");
        oper.setReturnType(new javax.xml.namespace.QName("http://negocio.geored.com/", "checkInDTO"));
        oper.setReturnClass(com.geored.negocio.CheckInDTO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("actualizar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuarioDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO"), com.geored.negocio.UsuarioDTO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerListado");
        oper.setReturnType(new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO"));
        oper.setReturnClass(com.geored.negocio.UsuarioDTO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("eliminar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "idUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerPorEmailYPass");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pass"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO"));
        oper.setReturnClass(com.geored.negocio.UsuarioDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuarioDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO"), com.geored.negocio.UsuarioDTO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtener");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "idUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO"));
        oper.setReturnClass(com.geored.negocio.UsuarioDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarNotificacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "notificacionDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://negocio.geored.com/", "notificacionDTO"), com.geored.negocio.NotificacionDTO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(java.lang.Long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"),
                      "com.geored.negocio.NegocioException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"),
                      "com.geored.negocio.DaoException",
                      new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    public UsuarioServiceImplServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public UsuarioServiceImplServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public UsuarioServiceImplServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "checkInDTO");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.CheckInDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "DaoException");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.DaoException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "mensajeAmistadDTO");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.MensajeAmistadDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "NegocioException");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.NegocioException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "notificacionDTO");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.NotificacionDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "tematicaDTO");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.TematicaDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO");
            cachedSerQNames.add(qName);
            cls = com.geored.negocio.UsuarioDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.String androidInvocation(java.lang.String methodName, java.lang.String methodParams) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "androidInvocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {methodName, methodParams});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Long enviarMensajeChat(com.geored.negocio.MensajeAmistadDTO mensajeAmistadDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "enviarMensajeChat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {mensajeAmistadDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.geored.negocio.CheckInDTO[] obtenerListadoCheckIns() throws java.rmi.RemoteException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "obtenerListadoCheckIns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.geored.negocio.CheckInDTO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.geored.negocio.CheckInDTO[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.geored.negocio.CheckInDTO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void actualizar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "actualizar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuarioDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.geored.negocio.UsuarioDTO[] obtenerListado() throws java.rmi.RemoteException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "obtenerListado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.geored.negocio.UsuarioDTO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.geored.negocio.UsuarioDTO[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.geored.negocio.UsuarioDTO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void eliminar(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "eliminar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {idUsuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.geored.negocio.UsuarioDTO obtenerPorEmailYPass(java.lang.String email, java.lang.String pass) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "obtenerPorEmailYPass"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {email, pass});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.geored.negocio.UsuarioDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.geored.negocio.UsuarioDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.geored.negocio.UsuarioDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Long insertar(com.geored.negocio.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "insertar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuarioDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.geored.negocio.UsuarioDTO obtener(java.lang.Long idUsuario) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "obtener"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {idUsuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.geored.negocio.UsuarioDTO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.geored.negocio.UsuarioDTO) org.apache.axis.utils.JavaUtils.convert(_resp, com.geored.negocio.UsuarioDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Long enviarNotificacion(com.geored.negocio.NotificacionDTO notificacionDTO) throws java.rmi.RemoteException, com.geored.negocio.NegocioException, com.geored.negocio.DaoException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://negocio.geored.com/", "enviarNotificacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {notificacionDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Long) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Long.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.NegocioException) {
              throw (com.geored.negocio.NegocioException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.geored.negocio.DaoException) {
              throw (com.geored.negocio.DaoException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
