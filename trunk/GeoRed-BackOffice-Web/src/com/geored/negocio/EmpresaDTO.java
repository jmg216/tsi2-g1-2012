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

    private com.geored.negocio.LocalDTO[] listaLocalesDTO;

    private java.lang.String nombre;

    private java.lang.String nombreAdministrador;

    private java.lang.String urlImagen;

    public EmpresaDTO() {
    }

    public EmpresaDTO(
           java.lang.String descripcion,
           java.util.Calendar fechaCreacion,
           java.lang.Long id,
           java.lang.Long idAministrador,
           com.geored.negocio.LocalDTO[] listaLocalesDTO,
           java.lang.String nombre,
           java.lang.String nombreAdministrador,
           java.lang.String urlImagen) {
           this.descripcion = descripcion;
           this.fechaCreacion = fechaCreacion;
           this.id = id;
           this.idAministrador = idAministrador;
           this.listaLocalesDTO = listaLocalesDTO;
           this.nombre = nombre;
           this.nombreAdministrador = nombreAdministrador;
           this.urlImagen = urlImagen;
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
     * Gets the listaLocalesDTO value for this EmpresaDTO.
     * 
     * @return listaLocalesDTO
     */
    public com.geored.negocio.LocalDTO[] getListaLocalesDTO() {
        return listaLocalesDTO;
    }


    /**
     * Sets the listaLocalesDTO value for this EmpresaDTO.
     * 
     * @param listaLocalesDTO
     */
    public void setListaLocalesDTO(com.geored.negocio.LocalDTO[] listaLocalesDTO) {
        this.listaLocalesDTO = listaLocalesDTO;
    }

    public com.geored.negocio.LocalDTO getListaLocalesDTO(int i) {
        return this.listaLocalesDTO[i];
    }

    public void setListaLocalesDTO(int i, com.geored.negocio.LocalDTO _value) {
        this.listaLocalesDTO[i] = _value;
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


    /**
     * Gets the urlImagen value for this EmpresaDTO.
     * 
     * @return urlImagen
     */
    public java.lang.String getUrlImagen() {
        return urlImagen;
    }


    /**
     * Sets the urlImagen value for this EmpresaDTO.
     * 
     * @param urlImagen
     */
    public void setUrlImagen(java.lang.String urlImagen) {
        this.urlImagen = urlImagen;
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
            ((this.listaLocalesDTO==null && other.getListaLocalesDTO()==null) || 
             (this.listaLocalesDTO!=null &&
              java.util.Arrays.equals(this.listaLocalesDTO, other.getListaLocalesDTO()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreAdministrador==null && other.getNombreAdministrador()==null) || 
             (this.nombreAdministrador!=null &&
              this.nombreAdministrador.equals(other.getNombreAdministrador()))) &&
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
        if (getFechaCreacion() != null) {
            _hashCode += getFechaCreacion().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdAministrador() != null) {
            _hashCode += getIdAministrador().hashCode();
        }
        if (getListaLocalesDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaLocalesDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaLocalesDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreAdministrador() != null) {
            _hashCode += getNombreAdministrador().hashCode();
        }
        if (getUrlImagen() != null) {
            _hashCode += getUrlImagen().hashCode();
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
        elemField.setFieldName("listaLocalesDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaLocalesDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "localDTO"));
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
        elemField.setFieldName("nombreAdministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreAdministrador"));
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
