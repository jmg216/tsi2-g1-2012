/**
 * EventoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class EventoDTO  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.util.Calendar fechaFin;

    private java.util.Calendar fechaInicio;

    private java.lang.Long id;

    private java.lang.Long idAministrador;

    private java.lang.String nombre;

    private java.lang.String nombreAdministrador;

    private java.lang.String ubicacionGeogrica;

    public EventoDTO() {
    }

    public EventoDTO(
           java.lang.String descripcion,
           java.util.Calendar fechaFin,
           java.util.Calendar fechaInicio,
           java.lang.Long id,
           java.lang.Long idAministrador,
           java.lang.String nombre,
           java.lang.String nombreAdministrador,
           java.lang.String ubicacionGeogrica) {
           this.descripcion = descripcion;
           this.fechaFin = fechaFin;
           this.fechaInicio = fechaInicio;
           this.id = id;
           this.idAministrador = idAministrador;
           this.nombre = nombre;
           this.nombreAdministrador = nombreAdministrador;
           this.ubicacionGeogrica = ubicacionGeogrica;
    }


    /**
     * Gets the descripcion value for this EventoDTO.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this EventoDTO.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the fechaFin value for this EventoDTO.
     * 
     * @return fechaFin
     */
    public java.util.Calendar getFechaFin() {
        return fechaFin;
    }


    /**
     * Sets the fechaFin value for this EventoDTO.
     * 
     * @param fechaFin
     */
    public void setFechaFin(java.util.Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }


    /**
     * Gets the fechaInicio value for this EventoDTO.
     * 
     * @return fechaInicio
     */
    public java.util.Calendar getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this EventoDTO.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.util.Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the id value for this EventoDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this EventoDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idAministrador value for this EventoDTO.
     * 
     * @return idAministrador
     */
    public java.lang.Long getIdAministrador() {
        return idAministrador;
    }


    /**
     * Sets the idAministrador value for this EventoDTO.
     * 
     * @param idAministrador
     */
    public void setIdAministrador(java.lang.Long idAministrador) {
        this.idAministrador = idAministrador;
    }


    /**
     * Gets the nombre value for this EventoDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this EventoDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreAdministrador value for this EventoDTO.
     * 
     * @return nombreAdministrador
     */
    public java.lang.String getNombreAdministrador() {
        return nombreAdministrador;
    }


    /**
     * Sets the nombreAdministrador value for this EventoDTO.
     * 
     * @param nombreAdministrador
     */
    public void setNombreAdministrador(java.lang.String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }


    /**
     * Gets the ubicacionGeogrica value for this EventoDTO.
     * 
     * @return ubicacionGeogrica
     */
    public java.lang.String getUbicacionGeogrica() {
        return ubicacionGeogrica;
    }


    /**
     * Sets the ubicacionGeogrica value for this EventoDTO.
     * 
     * @param ubicacionGeogrica
     */
    public void setUbicacionGeogrica(java.lang.String ubicacionGeogrica) {
        this.ubicacionGeogrica = ubicacionGeogrica;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventoDTO)) return false;
        EventoDTO other = (EventoDTO) obj;
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
            ((this.fechaFin==null && other.getFechaFin()==null) || 
             (this.fechaFin!=null &&
              this.fechaFin.equals(other.getFechaFin()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idAministrador==null && other.getIdAministrador()==null) || 
             (this.idAministrador!=null &&
              this.idAministrador.equals(other.getIdAministrador()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreAdministrador==null && other.getNombreAdministrador()==null) || 
             (this.nombreAdministrador!=null &&
              this.nombreAdministrador.equals(other.getNombreAdministrador()))) &&
            ((this.ubicacionGeogrica==null && other.getUbicacionGeogrica()==null) || 
             (this.ubicacionGeogrica!=null &&
              this.ubicacionGeogrica.equals(other.getUbicacionGeogrica())));
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
        if (getFechaFin() != null) {
            _hashCode += getFechaFin().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdAministrador() != null) {
            _hashCode += getIdAministrador().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreAdministrador() != null) {
            _hashCode += getNombreAdministrador().hashCode();
        }
        if (getUbicacionGeogrica() != null) {
            _hashCode += getUbicacionGeogrica().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "eventoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("idAministrador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAministrador"));
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
        elemField.setFieldName("ubicacionGeogrica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ubicacionGeogrica"));
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
