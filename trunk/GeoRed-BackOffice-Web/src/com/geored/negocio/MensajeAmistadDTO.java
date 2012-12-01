/**
 * MensajeAmistadDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class MensajeAmistadDTO  implements java.io.Serializable {
    private java.util.Calendar fechaCreacion;

    private java.lang.Long id;

    private java.lang.Long idAmistad;

    private java.lang.Long idRemitente;

    private java.lang.String mensaje;

    private java.lang.String nombreRemitente;

    public MensajeAmistadDTO() {
    }

    public MensajeAmistadDTO(
           java.util.Calendar fechaCreacion,
           java.lang.Long id,
           java.lang.Long idAmistad,
           java.lang.Long idRemitente,
           java.lang.String mensaje,
           java.lang.String nombreRemitente) {
           this.fechaCreacion = fechaCreacion;
           this.id = id;
           this.idAmistad = idAmistad;
           this.idRemitente = idRemitente;
           this.mensaje = mensaje;
           this.nombreRemitente = nombreRemitente;
    }


    /**
     * Gets the fechaCreacion value for this MensajeAmistadDTO.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this MensajeAmistadDTO.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the id value for this MensajeAmistadDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this MensajeAmistadDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idAmistad value for this MensajeAmistadDTO.
     * 
     * @return idAmistad
     */
    public java.lang.Long getIdAmistad() {
        return idAmistad;
    }


    /**
     * Sets the idAmistad value for this MensajeAmistadDTO.
     * 
     * @param idAmistad
     */
    public void setIdAmistad(java.lang.Long idAmistad) {
        this.idAmistad = idAmistad;
    }


    /**
     * Gets the idRemitente value for this MensajeAmistadDTO.
     * 
     * @return idRemitente
     */
    public java.lang.Long getIdRemitente() {
        return idRemitente;
    }


    /**
     * Sets the idRemitente value for this MensajeAmistadDTO.
     * 
     * @param idRemitente
     */
    public void setIdRemitente(java.lang.Long idRemitente) {
        this.idRemitente = idRemitente;
    }


    /**
     * Gets the mensaje value for this MensajeAmistadDTO.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this MensajeAmistadDTO.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the nombreRemitente value for this MensajeAmistadDTO.
     * 
     * @return nombreRemitente
     */
    public java.lang.String getNombreRemitente() {
        return nombreRemitente;
    }


    /**
     * Sets the nombreRemitente value for this MensajeAmistadDTO.
     * 
     * @param nombreRemitente
     */
    public void setNombreRemitente(java.lang.String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MensajeAmistadDTO)) return false;
        MensajeAmistadDTO other = (MensajeAmistadDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idAmistad==null && other.getIdAmistad()==null) || 
             (this.idAmistad!=null &&
              this.idAmistad.equals(other.getIdAmistad()))) &&
            ((this.idRemitente==null && other.getIdRemitente()==null) || 
             (this.idRemitente!=null &&
              this.idRemitente.equals(other.getIdRemitente()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.nombreRemitente==null && other.getNombreRemitente()==null) || 
             (this.nombreRemitente!=null &&
              this.nombreRemitente.equals(other.getNombreRemitente())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdAmistad() != null) {
            _hashCode += getIdAmistad().hashCode();
        }
        if (getIdRemitente() != null) {
            _hashCode += getIdRemitente().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getNombreRemitente() != null) {
            _hashCode += getNombreRemitente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MensajeAmistadDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "mensajeAmistadDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCreacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaCreacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAmistad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAmistad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRemitente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRemitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreRemitente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreRemitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
