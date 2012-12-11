/**
 * CheckInDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class CheckInDTO  implements java.io.Serializable {
    private java.util.Calendar fechaCreacion;

    private java.lang.Long id;

    private java.lang.Long idSitio;

    private java.lang.Long idUsuario;

    private java.lang.String nombreSitio;

    private java.lang.String nombreUsuario;

    public CheckInDTO() {
    }

    public CheckInDTO(
           java.util.Calendar fechaCreacion,
           java.lang.Long id,
           java.lang.Long idSitio,
           java.lang.Long idUsuario,
           java.lang.String nombreSitio,
           java.lang.String nombreUsuario) {
           this.fechaCreacion = fechaCreacion;
           this.id = id;
           this.idSitio = idSitio;
           this.idUsuario = idUsuario;
           this.nombreSitio = nombreSitio;
           this.nombreUsuario = nombreUsuario;
    }


    /**
     * Gets the fechaCreacion value for this CheckInDTO.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this CheckInDTO.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the id value for this CheckInDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this CheckInDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idSitio value for this CheckInDTO.
     * 
     * @return idSitio
     */
    public java.lang.Long getIdSitio() {
        return idSitio;
    }


    /**
     * Sets the idSitio value for this CheckInDTO.
     * 
     * @param idSitio
     */
    public void setIdSitio(java.lang.Long idSitio) {
        this.idSitio = idSitio;
    }


    /**
     * Gets the idUsuario value for this CheckInDTO.
     * 
     * @return idUsuario
     */
    public java.lang.Long getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this CheckInDTO.
     * 
     * @param idUsuario
     */
    public void setIdUsuario(java.lang.Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Gets the nombreSitio value for this CheckInDTO.
     * 
     * @return nombreSitio
     */
    public java.lang.String getNombreSitio() {
        return nombreSitio;
    }


    /**
     * Sets the nombreSitio value for this CheckInDTO.
     * 
     * @param nombreSitio
     */
    public void setNombreSitio(java.lang.String nombreSitio) {
        this.nombreSitio = nombreSitio;
    }


    /**
     * Gets the nombreUsuario value for this CheckInDTO.
     * 
     * @return nombreUsuario
     */
    public java.lang.String getNombreUsuario() {
        return nombreUsuario;
    }


    /**
     * Sets the nombreUsuario value for this CheckInDTO.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(java.lang.String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckInDTO)) return false;
        CheckInDTO other = (CheckInDTO) obj;
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
            ((this.idSitio==null && other.getIdSitio()==null) || 
             (this.idSitio!=null &&
              this.idSitio.equals(other.getIdSitio()))) &&
            ((this.idUsuario==null && other.getIdUsuario()==null) || 
             (this.idUsuario!=null &&
              this.idUsuario.equals(other.getIdUsuario()))) &&
            ((this.nombreSitio==null && other.getNombreSitio()==null) || 
             (this.nombreSitio!=null &&
              this.nombreSitio.equals(other.getNombreSitio()))) &&
            ((this.nombreUsuario==null && other.getNombreUsuario()==null) || 
             (this.nombreUsuario!=null &&
              this.nombreUsuario.equals(other.getNombreUsuario())));
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
        if (getIdSitio() != null) {
            _hashCode += getIdSitio().hashCode();
        }
        if (getIdUsuario() != null) {
            _hashCode += getIdUsuario().hashCode();
        }
        if (getNombreSitio() != null) {
            _hashCode += getNombreSitio().hashCode();
        }
        if (getNombreUsuario() != null) {
            _hashCode += getNombreUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckInDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "checkInDTO"));
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
        elemField.setFieldName("idSitio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSitio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreSitio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreSitio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreUsuario"));
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
