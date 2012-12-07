/**
 * UsuarioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class UsuarioDTO  implements java.io.Serializable {
    private java.lang.Boolean conectado;

    private java.lang.String email;

    private java.lang.String gcmRegId;

    private java.lang.Long id;

    private com.geored.negocio.TematicaDTO[] listaTematicasDTO;

    private java.lang.String nombre;

    private java.lang.String pass;

    private java.lang.String ubicacionActual;

    private java.lang.String urlImagen;

    public UsuarioDTO() {
    }

    public UsuarioDTO(
           java.lang.Boolean conectado,
           java.lang.String email,
           java.lang.String gcmRegId,
           java.lang.Long id,
           com.geored.negocio.TematicaDTO[] listaTematicasDTO,
           java.lang.String nombre,
           java.lang.String pass,
           java.lang.String ubicacionActual,
           java.lang.String urlImagen) {
           this.conectado = conectado;
           this.email = email;
           this.gcmRegId = gcmRegId;
           this.id = id;
           this.listaTematicasDTO = listaTematicasDTO;
           this.nombre = nombre;
           this.pass = pass;
           this.ubicacionActual = ubicacionActual;
           this.urlImagen = urlImagen;
    }


    /**
     * Gets the conectado value for this UsuarioDTO.
     * 
     * @return conectado
     */
    public java.lang.Boolean getConectado() {
        return conectado;
    }


    /**
     * Sets the conectado value for this UsuarioDTO.
     * 
     * @param conectado
     */
    public void setConectado(java.lang.Boolean conectado) {
        this.conectado = conectado;
    }


    /**
     * Gets the email value for this UsuarioDTO.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this UsuarioDTO.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the gcmRegId value for this UsuarioDTO.
     * 
     * @return gcmRegId
     */
    public java.lang.String getGcmRegId() {
        return gcmRegId;
    }


    /**
     * Sets the gcmRegId value for this UsuarioDTO.
     * 
     * @param gcmRegId
     */
    public void setGcmRegId(java.lang.String gcmRegId) {
        this.gcmRegId = gcmRegId;
    }


    /**
     * Gets the id value for this UsuarioDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this UsuarioDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the listaTematicasDTO value for this UsuarioDTO.
     * 
     * @return listaTematicasDTO
     */
    public com.geored.negocio.TematicaDTO[] getListaTematicasDTO() {
        return listaTematicasDTO;
    }


    /**
     * Sets the listaTematicasDTO value for this UsuarioDTO.
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
     * Gets the nombre value for this UsuarioDTO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this UsuarioDTO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the pass value for this UsuarioDTO.
     * 
     * @return pass
     */
    public java.lang.String getPass() {
        return pass;
    }


    /**
     * Sets the pass value for this UsuarioDTO.
     * 
     * @param pass
     */
    public void setPass(java.lang.String pass) {
        this.pass = pass;
    }


    /**
     * Gets the ubicacionActual value for this UsuarioDTO.
     * 
     * @return ubicacionActual
     */
    public java.lang.String getUbicacionActual() {
        return ubicacionActual;
    }


    /**
     * Sets the ubicacionActual value for this UsuarioDTO.
     * 
     * @param ubicacionActual
     */
    public void setUbicacionActual(java.lang.String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }


    /**
     * Gets the urlImagen value for this UsuarioDTO.
     * 
     * @return urlImagen
     */
    public java.lang.String getUrlImagen() {
        return urlImagen;
    }


    /**
     * Sets the urlImagen value for this UsuarioDTO.
     * 
     * @param urlImagen
     */
    public void setUrlImagen(java.lang.String urlImagen) {
        this.urlImagen = urlImagen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioDTO)) return false;
        UsuarioDTO other = (UsuarioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.conectado==null && other.getConectado()==null) || 
             (this.conectado!=null &&
              this.conectado.equals(other.getConectado()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.gcmRegId==null && other.getGcmRegId()==null) || 
             (this.gcmRegId!=null &&
              this.gcmRegId.equals(other.getGcmRegId()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.listaTematicasDTO==null && other.getListaTematicasDTO()==null) || 
             (this.listaTematicasDTO!=null &&
              java.util.Arrays.equals(this.listaTematicasDTO, other.getListaTematicasDTO()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.pass==null && other.getPass()==null) || 
             (this.pass!=null &&
              this.pass.equals(other.getPass()))) &&
            ((this.ubicacionActual==null && other.getUbicacionActual()==null) || 
             (this.ubicacionActual!=null &&
              this.ubicacionActual.equals(other.getUbicacionActual()))) &&
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
        if (getConectado() != null) {
            _hashCode += getConectado().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getGcmRegId() != null) {
            _hashCode += getGcmRegId().hashCode();
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
        if (getPass() != null) {
            _hashCode += getPass().hashCode();
        }
        if (getUbicacionActual() != null) {
            _hashCode += getUbicacionActual().hashCode();
        }
        if (getUrlImagen() != null) {
            _hashCode += getUrlImagen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UsuarioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "usuarioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conectado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conectado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gcmRegId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gcmRegId"));
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
        elemField.setFieldName("pass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicacionActual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ubicacionActual"));
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
