/**
 * TicketWSTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package obi1.fi.business.to;

public class TicketWSTO  implements java.io.Serializable {
    private java.lang.Integer idTickCdTicket;

    private java.lang.String tickDsDescricao;

    private java.lang.Integer tickNrDisponivel;

    private java.lang.Double tickNrValor;

    public TicketWSTO() {
    }

    public TicketWSTO(
           java.lang.Integer idTickCdTicket,
           java.lang.String tickDsDescricao,
           java.lang.Integer tickNrDisponivel,
           java.lang.Double tickNrValor) {
           this.idTickCdTicket = idTickCdTicket;
           this.tickDsDescricao = tickDsDescricao;
           this.tickNrDisponivel = tickNrDisponivel;
           this.tickNrValor = tickNrValor;
    }


    /**
     * Gets the idTickCdTicket value for this TicketWSTO.
     * 
     * @return idTickCdTicket
     */
    public java.lang.Integer getIdTickCdTicket() {
        return idTickCdTicket;
    }


    /**
     * Sets the idTickCdTicket value for this TicketWSTO.
     * 
     * @param idTickCdTicket
     */
    public void setIdTickCdTicket(java.lang.Integer idTickCdTicket) {
        this.idTickCdTicket = idTickCdTicket;
    }


    /**
     * Gets the tickDsDescricao value for this TicketWSTO.
     * 
     * @return tickDsDescricao
     */
    public java.lang.String getTickDsDescricao() {
        return tickDsDescricao;
    }


    /**
     * Sets the tickDsDescricao value for this TicketWSTO.
     * 
     * @param tickDsDescricao
     */
    public void setTickDsDescricao(java.lang.String tickDsDescricao) {
        this.tickDsDescricao = tickDsDescricao;
    }


    /**
     * Gets the tickNrDisponivel value for this TicketWSTO.
     * 
     * @return tickNrDisponivel
     */
    public java.lang.Integer getTickNrDisponivel() {
        return tickNrDisponivel;
    }


    /**
     * Sets the tickNrDisponivel value for this TicketWSTO.
     * 
     * @param tickNrDisponivel
     */
    public void setTickNrDisponivel(java.lang.Integer tickNrDisponivel) {
        this.tickNrDisponivel = tickNrDisponivel;
    }


    /**
     * Gets the tickNrValor value for this TicketWSTO.
     * 
     * @return tickNrValor
     */
    public java.lang.Double getTickNrValor() {
        return tickNrValor;
    }


    /**
     * Sets the tickNrValor value for this TicketWSTO.
     * 
     * @param tickNrValor
     */
    public void setTickNrValor(java.lang.Double tickNrValor) {
        this.tickNrValor = tickNrValor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TicketWSTO)) return false;
        TicketWSTO other = (TicketWSTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idTickCdTicket==null && other.getIdTickCdTicket()==null) || 
             (this.idTickCdTicket!=null &&
              this.idTickCdTicket.equals(other.getIdTickCdTicket()))) &&
            ((this.tickDsDescricao==null && other.getTickDsDescricao()==null) || 
             (this.tickDsDescricao!=null &&
              this.tickDsDescricao.equals(other.getTickDsDescricao()))) &&
            ((this.tickNrDisponivel==null && other.getTickNrDisponivel()==null) || 
             (this.tickNrDisponivel!=null &&
              this.tickNrDisponivel.equals(other.getTickNrDisponivel()))) &&
            ((this.tickNrValor==null && other.getTickNrValor()==null) || 
             (this.tickNrValor!=null &&
              this.tickNrValor.equals(other.getTickNrValor())));
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
        if (getIdTickCdTicket() != null) {
            _hashCode += getIdTickCdTicket().hashCode();
        }
        if (getTickDsDescricao() != null) {
            _hashCode += getTickDsDescricao().hashCode();
        }
        if (getTickNrDisponivel() != null) {
            _hashCode += getTickNrDisponivel().hashCode();
        }
        if (getTickNrValor() != null) {
            _hashCode += getTickNrValor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TicketWSTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://to.business.fi.obi1", "TicketWSTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTickCdTicket");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "idTickCdTicket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickDsDescricao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "tickDsDescricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickNrDisponivel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "tickNrDisponivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickNrValor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "tickNrValor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
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
