/**
 * OfertaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class OfertaDTO  implements java.io.Serializable {
    private java.lang.Double costo;

    private java.lang.String descripcion;

    private java.util.Calendar fechaFin;

    private java.util.Calendar fechaInicio;

    private java.lang.Long id;

    private java.lang.Long idLocal;

    private com.geored.negocio.TematicaDTO[] listaTematicasDTO;

    private java.lang.String nombre;

    private java.lang.String nombreLocal;

    private java.lang.String urlImagen;

    public OfertaDTO() {
    }

    public OfertaDTO(
           java.lang.Double costo,
           java.lang.String descripcion,
           java.util.Calendar fechaFin,
           java.util.Calendar fechaInicio,
           java.lang.Long id,
           java.lang.Long idLocal,
           com.geored.negocio.TematicaDTO[] listaTematicasDTO,
           java.lang.String nombre,
           java.lang.String nombreLocal,
           java.lang.String urlImagen) {
           this.costo = costo;
           this.descripcion = descripcion;
           this.fechaFin = fechaFin;
           this.fechaInicio = fechaInicio;
           this.id = id;
           this.idLocal = idLocal;
           this.listaTematicasDTO = listaTematicasDTO;
           this.nombre = nombre;
           this.nombreLocal = nombreLocal;
           this.urlImagen = urlImagen;
    }


    /**
     * Gets the costo value for this OfertaDTO.
     * 
     * @return costo
     */
    public java.lang.Double getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this OfertaDTO.
     * 
     * @param costo
     */
    public void setCosto(java.lang.Double costo) {
        this.costo = costo;
    }


    /**
     * Gets the descripcion value for this OfertaDTO.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this OfertaDTO.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the fechaFin value for this OfertaDTO.
     * 
     * @return fechaFin
     */
    public java.util.Calendar getFechaFin() {
        return fechaFin;
    }


    /**
     * Sets the fechaFin value for this OfertaDTO.
     * 
     * @param fechaFin
     */
    public void setFechaFin(java.util.Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }


    /**
     * Gets the fechaInicio value for this OfertaDTO.
     * 
     * @return fechaInicio
     */
    public java.util.Calendar getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this OfertaDTO.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.util.Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the id value for this OfertaDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this OfertaDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idLocal value for this OfertaDTO.
     * 
     * @return idLocal
     */
    public java.lang.Long getIdLocal() {
        return idLocal;
    }


    /**
     * Sets the idLocal value for this OfertaDTO.
     * 
     * @param idLocal
     */
    public void setIdLocal(java.lang.Long idLocal) {
        this.idLocal = idLocal;
    }


    /**
     * Gets the listaTematicasDTO value for this OfertaDTO.
     * 
     * @return listaTematicasDTO
     */
    public com.geored.negocio.TematicaDTO[] getListaTematicasDTO() {
        return listaTematicasDTO;
    }


    /**
     * Sets the listaTematicasDTO value for this OfertaDTO.
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
     * Gets the nombre value for this OfertaDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this OfertaDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreLocal value for this OfertaDTO.
     * 
     * @return nombreLocal
     */
    public java.lang.String getNombreLocal() {
        return nombreLocal;
    }


    /**
     * Sets the nombreLocal value for this OfertaDTO.
     * 
     * @param nombreLocal
     */
    public void setNombreLocal(java.lang.String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }


    /**
     * Gets the urlImagen value for this OfertaDTO.
     * 
     * @return urlImagen
     */
    public java.lang.String getUrlImagen() {
        return urlImagen;
    }


    /**
     * Sets the urlImagen value for this OfertaDTO.
     * 
     * @param urlImagen
     */
    public void setUrlImagen(java.lang.String urlImagen) {
        this.urlImagen = urlImagen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OfertaDTO)) return false;
        OfertaDTO other = (OfertaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.costo==null && other.getCosto()==null) || 
             (this.costo!=null &&
              this.costo.equals(other.getCosto()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.fechaFin==null && other.getFechaFin()==null) || 
             (this.fechaFin!=null &&
              this.fechaFin.equals(other.getFechaFin()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idLocal==null && other.getIdLocal()==null) || 
             (this.idLocal!=null &&
              this.idLocal.equals(other.getIdLocal()))) &&
            ((this.listaTematicasDTO==null && other.getListaTematicasDTO()==null) || 
             (this.listaTematicasDTO!=null &&
              java.util.Arrays.equals(this.listaTematicasDTO, other.getListaTematicasDTO()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreLocal==null && other.getNombreLocal()==null) || 
             (this.nombreLocal!=null &&
              this.nombreLocal.equals(other.getNombreLocal()))) &&
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
        if (getCosto() != null) {
            _hashCode += getCosto().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getFechaFin() != null) {
            _hashCode += getFechaFin().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdLocal() != null) {
            _hashCode += getIdLocal().hashCode();
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
        if (getNombreLocal() != null) {
            _hashCode += getNombreLocal().hashCode();
        }
        if (getUrlImagen() != null) {
            _hashCode += getUrlImagen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OfertaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "ofertaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaInicio"));
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
        elemField.setFieldName("idLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idLocal"));
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
        elemField.setFieldName("nombreLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreLocal"));
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
