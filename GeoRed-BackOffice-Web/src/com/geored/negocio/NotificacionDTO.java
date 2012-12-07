/**
 * NotificacionDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class NotificacionDTO  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.Long id;

    private java.lang.Long idTipoNotificacion;

    private java.lang.Long idUsuarioDestino;

    private boolean leida;

    private java.lang.String nombreTipoNotificacion;

    private java.lang.String nombreUsuarioDestino;

    public NotificacionDTO() {
    }

    public NotificacionDTO(
           java.lang.String descripcion,
           java.lang.Long id,
           java.lang.Long idTipoNotificacion,
           java.lang.Long idUsuarioDestino,
           boolean leida,
           java.lang.String nombreTipoNotificacion,
           java.lang.String nombreUsuarioDestino) {
           this.descripcion = descripcion;
           this.id = id;
           this.idTipoNotificacion = idTipoNotificacion;
           this.idUsuarioDestino = idUsuarioDestino;
           this.leida = leida;
           this.nombreTipoNotificacion = nombreTipoNotificacion;
           this.nombreUsuarioDestino = nombreUsuarioDestino;
    }


    /**
     * Gets the descripcion value for this NotificacionDTO.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this NotificacionDTO.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the id value for this NotificacionDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this NotificacionDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idTipoNotificacion value for this NotificacionDTO.
     * 
     * @return idTipoNotificacion
     */
    public java.lang.Long getIdTipoNotificacion() {
        return idTipoNotificacion;
    }


    /**
     * Sets the idTipoNotificacion value for this NotificacionDTO.
     * 
     * @param idTipoNotificacion
     */
    public void setIdTipoNotificacion(java.lang.Long idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }


    /**
     * Gets the idUsuarioDestino value for this NotificacionDTO.
     * 
     * @return idUsuarioDestino
     */
    public java.lang.Long getIdUsuarioDestino() {
        return idUsuarioDestino;
    }


    /**
     * Sets the idUsuarioDestino value for this NotificacionDTO.
     * 
     * @param idUsuarioDestino
     */
    public void setIdUsuarioDestino(java.lang.Long idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }


    /**
     * Gets the leida value for this NotificacionDTO.
     * 
     * @return leida
     */
    public boolean isLeida() {
        return leida;
    }


    /**
     * Sets the leida value for this NotificacionDTO.
     * 
     * @param leida
     */
    public void setLeida(boolean leida) {
        this.leida = leida;
    }


    /**
     * Gets the nombreTipoNotificacion value for this NotificacionDTO.
     * 
     * @return nombreTipoNotificacion
     */
    public java.lang.String getNombreTipoNotificacion() {
        return nombreTipoNotificacion;
    }


    /**
     * Sets the nombreTipoNotificacion value for this NotificacionDTO.
     * 
     * @param nombreTipoNotificacion
     */
    public void setNombreTipoNotificacion(java.lang.String nombreTipoNotificacion) {
        this.nombreTipoNotificacion = nombreTipoNotificacion;
    }


    /**
     * Gets the nombreUsuarioDestino value for this NotificacionDTO.
     * 
     * @return nombreUsuarioDestino
     */
    public java.lang.String getNombreUsuarioDestino() {
        return nombreUsuarioDestino;
    }


    /**
     * Sets the nombreUsuarioDestino value for this NotificacionDTO.
     * 
     * @param nombreUsuarioDestino
     */
    public void setNombreUsuarioDestino(java.lang.String nombreUsuarioDestino) {
        this.nombreUsuarioDestino = nombreUsuarioDestino;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NotificacionDTO)) return false;
        NotificacionDTO other = (NotificacionDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idTipoNotificacion==null && other.getIdTipoNotificacion()==null) || 
             (this.idTipoNotificacion!=null &&
              this.idTipoNotificacion.equals(other.getIdTipoNotificacion()))) &&
            ((this.idUsuarioDestino==null && other.getIdUsuarioDestino()==null) || 
             (this.idUsuarioDestino!=null &&
              this.idUsuarioDestino.equals(other.getIdUsuarioDestino()))) &&
            this.leida == other.isLeida() &&
            ((this.nombreTipoNotificacion==null && other.getNombreTipoNotificacion()==null) || 
             (this.nombreTipoNotificacion!=null &&
              this.nombreTipoNotificacion.equals(other.getNombreTipoNotificacion()))) &&
            ((this.nombreUsuarioDestino==null && other.getNombreUsuarioDestino()==null) || 
             (this.nombreUsuarioDestino!=null &&
              this.nombreUsuarioDestino.equals(other.getNombreUsuarioDestino())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdTipoNotificacion() != null) {
            _hashCode += getIdTipoNotificacion().hashCode();
        }
        if (getIdUsuarioDestino() != null) {
            _hashCode += getIdUsuarioDestino().hashCode();
        }
        _hashCode += (isLeida() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getNombreTipoNotificacion() != null) {
            _hashCode += getNombreTipoNotificacion().hashCode();
        }
        if (getNombreUsuarioDestino() != null) {
            _hashCode += getNombreUsuarioDestino().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NotificacionDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "notificacionDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("idTipoNotificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoNotificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuarioDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuarioDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreTipoNotificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreTipoNotificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuarioDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreUsuarioDestino"));
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
