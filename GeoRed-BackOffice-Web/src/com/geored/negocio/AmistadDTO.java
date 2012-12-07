/**
 * AmistadDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.geored.negocio;

public class AmistadDTO  implements java.io.Serializable {
    private java.lang.Long id;

    private java.lang.Long idUsuarioA;

    private java.lang.Long idUsuarioB;

    private com.geored.negocio.MensajeAmistadDTO[] listaMensajesDTO;

    private java.lang.String nombreUsuarioA;

    private java.lang.String nombreUsuarioB;

    public AmistadDTO() {
    }

    public AmistadDTO(
           java.lang.Long id,
           java.lang.Long idUsuarioA,
           java.lang.Long idUsuarioB,
           com.geored.negocio.MensajeAmistadDTO[] listaMensajesDTO,
           java.lang.String nombreUsuarioA,
           java.lang.String nombreUsuarioB) {
           this.id = id;
           this.idUsuarioA = idUsuarioA;
           this.idUsuarioB = idUsuarioB;
           this.listaMensajesDTO = listaMensajesDTO;
           this.nombreUsuarioA = nombreUsuarioA;
           this.nombreUsuarioB = nombreUsuarioB;
    }


    /**
     * Gets the id value for this AmistadDTO.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this AmistadDTO.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the idUsuarioA value for this AmistadDTO.
     * 
     * @return idUsuarioA
     */
    public java.lang.Long getIdUsuarioA() {
        return idUsuarioA;
    }


    /**
     * Sets the idUsuarioA value for this AmistadDTO.
     * 
     * @param idUsuarioA
     */
    public void setIdUsuarioA(java.lang.Long idUsuarioA) {
        this.idUsuarioA = idUsuarioA;
    }


    /**
     * Gets the idUsuarioB value for this AmistadDTO.
     * 
     * @return idUsuarioB
     */
    public java.lang.Long getIdUsuarioB() {
        return idUsuarioB;
    }


    /**
     * Sets the idUsuarioB value for this AmistadDTO.
     * 
     * @param idUsuarioB
     */
    public void setIdUsuarioB(java.lang.Long idUsuarioB) {
        this.idUsuarioB = idUsuarioB;
    }


    /**
     * Gets the listaMensajesDTO value for this AmistadDTO.
     * 
     * @return listaMensajesDTO
     */
    public com.geored.negocio.MensajeAmistadDTO[] getListaMensajesDTO() {
        return listaMensajesDTO;
    }


    /**
     * Sets the listaMensajesDTO value for this AmistadDTO.
     * 
     * @param listaMensajesDTO
     */
    public void setListaMensajesDTO(com.geored.negocio.MensajeAmistadDTO[] listaMensajesDTO) {
        this.listaMensajesDTO = listaMensajesDTO;
    }

    public com.geored.negocio.MensajeAmistadDTO getListaMensajesDTO(int i) {
        return this.listaMensajesDTO[i];
    }

    public void setListaMensajesDTO(int i, com.geored.negocio.MensajeAmistadDTO _value) {
        this.listaMensajesDTO[i] = _value;
    }


    /**
     * Gets the nombreUsuarioA value for this AmistadDTO.
     * 
     * @return nombreUsuarioA
     */
    public java.lang.String getNombreUsuarioA() {
        return nombreUsuarioA;
    }


    /**
     * Sets the nombreUsuarioA value for this AmistadDTO.
     * 
     * @param nombreUsuarioA
     */
    public void setNombreUsuarioA(java.lang.String nombreUsuarioA) {
        this.nombreUsuarioA = nombreUsuarioA;
    }


    /**
     * Gets the nombreUsuarioB value for this AmistadDTO.
     * 
     * @return nombreUsuarioB
     */
    public java.lang.String getNombreUsuarioB() {
        return nombreUsuarioB;
    }


    /**
     * Sets the nombreUsuarioB value for this AmistadDTO.
     * 
     * @param nombreUsuarioB
     */
    public void setNombreUsuarioB(java.lang.String nombreUsuarioB) {
        this.nombreUsuarioB = nombreUsuarioB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AmistadDTO)) return false;
        AmistadDTO other = (AmistadDTO) obj;
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
            ((this.idUsuarioA==null && other.getIdUsuarioA()==null) || 
             (this.idUsuarioA!=null &&
              this.idUsuarioA.equals(other.getIdUsuarioA()))) &&
            ((this.idUsuarioB==null && other.getIdUsuarioB()==null) || 
             (this.idUsuarioB!=null &&
              this.idUsuarioB.equals(other.getIdUsuarioB()))) &&
            ((this.listaMensajesDTO==null && other.getListaMensajesDTO()==null) || 
             (this.listaMensajesDTO!=null &&
              java.util.Arrays.equals(this.listaMensajesDTO, other.getListaMensajesDTO()))) &&
            ((this.nombreUsuarioA==null && other.getNombreUsuarioA()==null) || 
             (this.nombreUsuarioA!=null &&
              this.nombreUsuarioA.equals(other.getNombreUsuarioA()))) &&
            ((this.nombreUsuarioB==null && other.getNombreUsuarioB()==null) || 
             (this.nombreUsuarioB!=null &&
              this.nombreUsuarioB.equals(other.getNombreUsuarioB())));
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
        if (getIdUsuarioA() != null) {
            _hashCode += getIdUsuarioA().hashCode();
        }
        if (getIdUsuarioB() != null) {
            _hashCode += getIdUsuarioB().hashCode();
        }
        if (getListaMensajesDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaMensajesDTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaMensajesDTO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombreUsuarioA() != null) {
            _hashCode += getNombreUsuarioA().hashCode();
        }
        if (getNombreUsuarioB() != null) {
            _hashCode += getNombreUsuarioB().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AmistadDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "amistadDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuarioA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuarioA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuarioB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuarioB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaMensajesDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaMensajesDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://negocio.geored.com/", "mensajeAmistadDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuarioA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreUsuarioA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuarioB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreUsuarioB"));
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
