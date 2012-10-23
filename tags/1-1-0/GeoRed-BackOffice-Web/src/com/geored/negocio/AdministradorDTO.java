/**
 * AdministradorDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class AdministradorDTO  implements java.io.Serializable {
    private java.lang.Long id;

    private java.lang.Long idTipoAdministrador;

    private java.lang.String nombre;

    private java.lang.String nombreTipoAdministrador;

    private java.lang.String pass;

    public AdministradorDTO() {
    }

    public AdministradorDTO(
           java.lang.Long id,
           java.lang.Long idTipoAdministrador,
           java.lang.String nombre,
           java.lang.String nombreTipoAdministrador,
           java.lang.String pass) {
           this.id = id;
           this.idTipoAdministrador = idTipoAdministrador;
           this.nombre = nombre;
           this.nombreTipoAdministrador = nombreTipoAdministrador;
           this.pass = pass;
    }


    /**
     * Gets the id value for this AdministradorDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this AdministradorDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idTipoAdministrador value for this AdministradorDTO.
     * 
     * @return idTipoAdministrador
     */
    public java.lang.Long getIdTipoAdministrador() {
        return idTipoAdministrador;
    }


    /**
     * Sets the idTipoAdministrador value for this AdministradorDTO.
     * 
     * @param idTipoAdministrador
     */
    public void setIdTipoAdministrador(java.lang.Long idTipoAdministrador) {
        this.idTipoAdministrador = idTipoAdministrador;
    }


    /**
     * Gets the nombre value for this AdministradorDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this AdministradorDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreTipoAdministrador value for this AdministradorDTO.
     * 
     * @return nombreTipoAdministrador
     */
    public java.lang.String getNombreTipoAdministrador() {
        return nombreTipoAdministrador;
    }


    /**
     * Sets the nombreTipoAdministrador value for this AdministradorDTO.
     * 
     * @param nombreTipoAdministrador
     */
    public void setNombreTipoAdministrador(java.lang.String nombreTipoAdministrador) {
        this.nombreTipoAdministrador = nombreTipoAdministrador;
    }


    /**
     * Gets the pass value for this AdministradorDTO.
     * 
     * @return pass
     */
    public java.lang.String getPass() {
        return pass;
    }


    /**
     * Sets the pass value for this AdministradorDTO.
     * 
     * @param pass
     */
    public void setPass(java.lang.String pass) {
        this.pass = pass;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdministradorDTO)) return false;
        AdministradorDTO other = (AdministradorDTO) obj;
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
            ((this.idTipoAdministrador==null && other.getIdTipoAdministrador()==null) || 
             (this.idTipoAdministrador!=null &&
              this.idTipoAdministrador.equals(other.getIdTipoAdministrador()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreTipoAdministrador==null && other.getNombreTipoAdministrador()==null) || 
             (this.nombreTipoAdministrador!=null &&
              this.nombreTipoAdministrador.equals(other.getNombreTipoAdministrador()))) &&
            ((this.pass==null && other.getPass()==null) || 
             (this.pass!=null &&
              this.pass.equals(other.getPass())));
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
        if (getIdTipoAdministrador() != null) {
            _hashCode += getIdTipoAdministrador().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreTipoAdministrador() != null) {
            _hashCode += getNombreTipoAdministrador().hashCode();
        }
        if (getPass() != null) {
            _hashCode += getPass().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdministradorDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "administradorDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTipoAdministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoAdministrador"));
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
        elemField.setFieldName("nombreTipoAdministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreTipoAdministrador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pass"));
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
