/**
 * NotificacionDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class NotificacionDTO  implements java.io.Serializable {
    private java.lang.Long id;

    private java.lang.Long idTipoNotificacion;

    private java.lang.Long idUsuario;

    private java.lang.String nombre;

    private java.lang.String nombreTipoNotificacion;

    private java.lang.String nombreUsuario;

    public NotificacionDTO() {
    }

    public NotificacionDTO(
           java.lang.Long id,
           java.lang.Long idTipoNotificacion,
           java.lang.Long idUsuario,
           java.lang.String nombre,
           java.lang.String nombreTipoNotificacion,
           java.lang.String nombreUsuario) {
           this.id = id;
           this.idTipoNotificacion = idTipoNotificacion;
           this.idUsuario = idUsuario;
           this.nombre = nombre;
           this.nombreTipoNotificacion = nombreTipoNotificacion;
           this.nombreUsuario = nombreUsuario;
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
     * Gets the idUsuario value for this NotificacionDTO.
     * 
     * @return idUsuario
     */
    public java.lang.Long getIdUsuario() {
        return idUsuario;
    }


    /**
     * Sets the idUsuario value for this NotificacionDTO.
     * 
     * @param idUsuario
     */
    public void setIdUsuario(java.lang.Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Gets the nombre value for this NotificacionDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this NotificacionDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
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
     * Gets the nombreUsuario value for this NotificacionDTO.
     * 
     * @return nombreUsuario
     */
    public java.lang.String getNombreUsuario() {
        return nombreUsuario;
    }


    /**
     * Sets the nombreUsuario value for this NotificacionDTO.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(java.lang.String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idTipoNotificacion==null && other.getIdTipoNotificacion()==null) || 
             (this.idTipoNotificacion!=null &&
              this.idTipoNotificacion.equals(other.getIdTipoNotificacion()))) &&
            ((this.idUsuario==null && other.getIdUsuario()==null) || 
             (this.idUsuario!=null &&
              this.idUsuario.equals(other.getIdUsuario()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreTipoNotificacion==null && other.getNombreTipoNotificacion()==null) || 
             (this.nombreTipoNotificacion!=null &&
              this.nombreTipoNotificacion.equals(other.getNombreTipoNotificacion()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdTipoNotificacion() != null) {
            _hashCode += getIdTipoNotificacion().hashCode();
        }
        if (getIdUsuario() != null) {
            _hashCode += getIdUsuario().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreTipoNotificacion() != null) {
            _hashCode += getNombreTipoNotificacion().hashCode();
        }
        if (getNombreUsuario() != null) {
            _hashCode += getNombreUsuario().hashCode();
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
        elemField.setFieldName("idUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
