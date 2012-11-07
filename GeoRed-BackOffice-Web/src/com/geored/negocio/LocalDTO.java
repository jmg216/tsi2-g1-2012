/**
 * LocalDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class LocalDTO  implements java.io.Serializable {
    private java.lang.Long id;

    private java.lang.Long idEmpresa;

    private java.lang.String nombre;

    private java.lang.String nombreEmpresa;

    private java.lang.String ubicacionGeografica;

    public LocalDTO() {
    }

    public LocalDTO(
           java.lang.Long id,
           java.lang.Long idEmpresa,
           java.lang.String nombre,
           java.lang.String nombreEmpresa,
           java.lang.String ubicacionGeografica) {
           this.id = id;
           this.idEmpresa = idEmpresa;
           this.nombre = nombre;
           this.nombreEmpresa = nombreEmpresa;
           this.ubicacionGeografica = ubicacionGeografica;
    }


    /**
     * Gets the id value for this LocalDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this LocalDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idEmpresa value for this LocalDTO.
     * 
     * @return idEmpresa
     */
    public java.lang.Long getIdEmpresa() {
        return idEmpresa;
    }


    /**
     * Sets the idEmpresa value for this LocalDTO.
     * 
     * @param idEmpresa
     */
    public void setIdEmpresa(java.lang.Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    /**
     * Gets the nombre value for this LocalDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this LocalDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreEmpresa value for this LocalDTO.
     * 
     * @return nombreEmpresa
     */
    public java.lang.String getNombreEmpresa() {
        return nombreEmpresa;
    }


    /**
     * Sets the nombreEmpresa value for this LocalDTO.
     * 
     * @param nombreEmpresa
     */
    public void setNombreEmpresa(java.lang.String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }


    /**
     * Gets the ubicacionGeografica value for this LocalDTO.
     * 
     * @return ubicacionGeografica
     */
    public java.lang.String getUbicacionGeografica() {
        return ubicacionGeografica;
    }


    /**
     * Sets the ubicacionGeografica value for this LocalDTO.
     * 
     * @param ubicacionGeografica
     */
    public void setUbicacionGeografica(java.lang.String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LocalDTO)) return false;
        LocalDTO other = (LocalDTO) obj;
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
            ((this.idEmpresa==null && other.getIdEmpresa()==null) || 
             (this.idEmpresa!=null &&
              this.idEmpresa.equals(other.getIdEmpresa()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreEmpresa==null && other.getNombreEmpresa()==null) || 
             (this.nombreEmpresa!=null &&
              this.nombreEmpresa.equals(other.getNombreEmpresa()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdEmpresa() != null) {
            _hashCode += getIdEmpresa().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreEmpresa() != null) {
            _hashCode += getNombreEmpresa().hashCode();
        }
        if (getUbicacionGeografica() != null) {
            _hashCode += getUbicacionGeografica().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocalDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "localDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEmpresa"));
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
        elemField.setFieldName("nombreEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreEmpresa"));
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
