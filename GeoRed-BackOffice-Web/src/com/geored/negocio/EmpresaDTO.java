/**
 * EmpresaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class EmpresaDTO  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.util.Calendar fechaCreacion;

    private java.lang.Long id;

    private java.lang.Long idAministrador;

    private java.lang.String logoUrl;

    private java.lang.String nombre;

    private java.lang.String nombreAdministrador;

    public EmpresaDTO() {
    }

    public EmpresaDTO(
           java.lang.String descripcion,
           java.util.Calendar fechaCreacion,
           java.lang.Long id,
           java.lang.Long idAministrador,
           java.lang.String logoUrl,
           java.lang.String nombre,
           java.lang.String nombreAdministrador) {
           this.descripcion = descripcion;
           this.fechaCreacion = fechaCreacion;
           this.id = id;
           this.idAministrador = idAministrador;
           this.logoUrl = logoUrl;
           this.nombre = nombre;
           this.nombreAdministrador = nombreAdministrador;
    }


    /**
     * Gets the descripcion value for this EmpresaDTO.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this EmpresaDTO.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the fechaCreacion value for this EmpresaDTO.
     * 
     * @return fechaCreacion
     */
    public java.util.Calendar getFechaCreacion() {
        return fechaCreacion;
    }


    /**
     * Sets the fechaCreacion value for this EmpresaDTO.
     * 
     * @param fechaCreacion
     */
    public void setFechaCreacion(java.util.Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    /**
     * Gets the id value for this EmpresaDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this EmpresaDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idAministrador value for this EmpresaDTO.
     * 
     * @return idAministrador
     */
    public java.lang.Long getIdAministrador() {
        return idAministrador;
    }


    /**
     * Sets the idAministrador value for this EmpresaDTO.
     * 
     * @param idAministrador
     */
    public void setIdAministrador(java.lang.Long idAministrador) {
        this.idAministrador = idAministrador;
    }


    /**
     * Gets the logoUrl value for this EmpresaDTO.
     * 
     * @return logoUrl
     */
    public java.lang.String getLogoUrl() {
        return logoUrl;
    }


    /**
     * Sets the logoUrl value for this EmpresaDTO.
     * 
     * @param logoUrl
     */
    public void setLogoUrl(java.lang.String logoUrl) {
        this.logoUrl = logoUrl;
    }


    /**
     * Gets the nombre value for this EmpresaDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this EmpresaDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreAdministrador value for this EmpresaDTO.
     * 
     * @return nombreAdministrador
     */
    public java.lang.String getNombreAdministrador() {
        return nombreAdministrador;
    }


    /**
     * Sets the nombreAdministrador value for this EmpresaDTO.
     * 
     * @param nombreAdministrador
     */
    public void setNombreAdministrador(java.lang.String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmpresaDTO)) return false;
        EmpresaDTO other = (EmpresaDTO) obj;
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
            ((this.fechaCreacion==null && other.getFechaCreacion()==null) || 
             (this.fechaCreacion!=null &&
              this.fechaCreacion.equals(other.getFechaCreacion()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idAministrador==null && other.getIdAministrador()==null) || 
             (this.idAministrador!=null &&
              this.idAministrador.equals(other.getIdAministrador()))) &&
            ((this.logoUrl==null && other.getLogoUrl()==null) || 
             (this.logoUrl!=null &&
              this.logoUrl.equals(other.getLogoUrl()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreAdministrador==null && other.getNombreAdministrador()==null) || 
             (this.nombreAdministrador!=null &&
              this.nombreAdministrador.equals(other.getNombreAdministrador())));
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
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdAministrador() != null) {
            _hashCode += getIdAministrador().hashCode();
        }
        if (getLogoUrl() != null) {
            _hashCode += getLogoUrl().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreAdministrador() != null) {
            _hashCode += getNombreAdministrador().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmpresaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "empresaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("idAministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAministrador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logoUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logoUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("nombreAdministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreAdministrador"));
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
