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

    private com.geored.negocio.TematicaDTO[] listaTematicasDTO;

    private java.lang.String nombre;

    private java.lang.String ubicacionGeografica;

    private java.lang.String urlImagen;

    public SitioDTO() {
    }

    public SitioDTO(
           java.lang.String descripcion,
           java.lang.Long id,
           com.geored.negocio.TematicaDTO[] listaTematicasDTO,
           java.lang.String nombre,
           java.lang.String ubicacionGeografica,
           java.lang.String urlImagen) {
           this.descripcion = descripcion;
           this.id = id;
           this.listaTematicasDTO = listaTematicasDTO;
           this.nombre = nombre;
           this.ubicacionGeografica = ubicacionGeografica;
           this.urlImagen = urlImagen;
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
     * Gets the listaTematicasDTO value for this SitioDTO.
     * 
     * @return listaTematicasDTO
     */
    public com.geored.negocio.TematicaDTO[] getListaTematicasDTO() {
        return listaTematicasDTO;
    }


    /**
     * Sets the listaTematicasDTO value for this SitioDTO.
     * 
     * @param listaTematicasDTO
     */
    public void setListaTematicasDTO(com.geored.negocio.TematicaDTO[] listaTematicasDTO) {
        this.listaTematicasDTO = listaTematicasDTO;
    }

    public com.geored.negocio.TematicaDTO getListaTematicasDTO(int i) {
        return this.listaTematicasDTO[i];
    }

    public void setListaTematicasDTO(int i, com.geored.negocio.TematicaDTO _value) {
        this.listaTematicasDTO[i] = _value;
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


    /**
     * Gets the urlImagen value for this SitioDTO.
     * 
     * @return urlImagen
     */
    public java.lang.String getUrlImagen() {
        return urlImagen;
    }


    /**
     * Sets the urlImagen value for this SitioDTO.
     * 
     * @param urlImagen
     */
    public void setUrlImagen(java.lang.String urlImagen) {
        this.urlImagen = urlImagen;
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
            ((this.listaTematicasDTO==null && other.getListaTematicasDTO()==null) || 
             (this.listaTematicasDTO!=null &&
              java.util.Arrays.equals(this.listaTematicasDTO, other.getListaTematicasDTO()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.ubicacionGeografica==null && other.getUbicacionGeografica()==null) || 
             (this.ubicacionGeografica!=null &&
              this.ubicacionGeografica.equals(other.getUbicacionGeografica()))) &&
            ((this.urlImagen==null && other.getUrlImagen()==null) || 
             (this.urlImagen!=null &&
              this.urlImagen.equals(other.getUrlImagen())));
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
        if (getListaTematicasDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaTematicasDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaTematicasDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getUbicacionGeografica() != null) {
            _hashCode += getUbicacionGeografica().hashCode();
        }
        if (getUrlImagen() != null) {
            _hashCode += getUrlImagen().hashCode();
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
        elemField.setFieldName("listaTematicasDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaTematicasDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "tematicaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlImagen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "urlImagen"));
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
