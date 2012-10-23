/**
 * SitioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class SitioDTO  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.Long id;

    private java.lang.Long idAdministrador;

    private java.lang.String nombre;

    private java.lang.String nombreAdministrador;

    private java.lang.String ubicacionGeografica;

    public SitioDTO() {
    }

    public SitioDTO(
           java.lang.String descripcion,
           java.lang.Long id,
           java.lang.Long idAdministrador,
           java.lang.String nombre,
           java.lang.String nombreAdministrador,
           java.lang.String ubicacionGeografica) {
           this.descripcion = descripcion;
           this.id = id;
           this.idAdministrador = idAdministrador;
           this.nombre = nombre;
           this.nombreAdministrador = nombreAdministrador;
           this.ubicacionGeografica = ubicacionGeografica;
    }


    /**
     * Gets the descripcion value for this SitioDTO.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this SitioDTO.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the id value for this SitioDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this SitioDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idAdministrador value for this SitioDTO.
     * 
     * @return idAdministrador
     */
    public java.lang.Long getIdAdministrador() {
        return idAdministrador;
    }


    /**
     * Sets the idAdministrador value for this SitioDTO.
     * 
     * @param idAdministrador
     */
    public void setIdAdministrador(java.lang.Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }


    /**
     * Gets the nombre value for this SitioDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this SitioDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreAdministrador value for this SitioDTO.
     * 
     * @return nombreAdministrador
     */
    public java.lang.String getNombreAdministrador() {
        return nombreAdministrador;
    }


    /**
     * Sets the nombreAdministrador value for this SitioDTO.
     * 
     * @param nombreAdministrador
     */
    public void setNombreAdministrador(java.lang.String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }


    /**
     * Gets the ubicacionGeografica value for this SitioDTO.
     * 
     * @return ubicacionGeografica
     */
    public java.lang.String getUbicacionGeografica() {
        return ubicacionGeografica;
    }


    /**
     * Sets the ubicacionGeografica value for this SitioDTO.
     * 
     * @param ubicacionGeografica
     */
    public void setUbicacionGeografica(java.lang.String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SitioDTO)) return false;
        SitioDTO other = (SitioDTO) obj;
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
            ((this.idAdministrador==null && other.getIdAdministrador()==null) || 
             (this.idAdministrador!=null &&
              this.idAdministrador.equals(other.getIdAdministrador()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreAdministrador==null && other.getNombreAdministrador()==null) || 
             (this.nombreAdministrador!=null &&
              this.nombreAdministrador.equals(other.getNombreAdministrador()))) &&
            ((this.ubicacionGeografica==null && other.getUbicacionGeografica()==null) || 
             (this.ubicacionGeografica!=null &&
              this.ubicacionGeografica.equals(other.getUbicacionGeografica())));
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
        if (getIdAdministrador() != null) {
            _hashCode += getIdAdministrador().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreAdministrador() != null) {
            _hashCode += getNombreAdministrador().hashCode();
        }
        if (getUbicacionGeografica() != null) {
            _hashCode += getUbicacionGeografica().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SitioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "sitioDTO"));
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
        elemField.setFieldName("idAdministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAdministrador"));
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
        elemField.setFieldName("nombreAdministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreAdministrador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicacionGeografica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ubicacionGeografica"));
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
