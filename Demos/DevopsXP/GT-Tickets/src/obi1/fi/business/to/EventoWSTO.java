/**
 * EventoWSTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package obi1.fi.business.to;

public class EventoWSTO  implements java.io.Serializable {
    private java.lang.String evenCdTipo;

    private java.lang.String evenDhEvento;

    private java.lang.String evenDsDescricao;

    private java.lang.String evenDsLocal;

    private java.lang.String evenDsTitulo;

    private java.lang.Integer idEvenCdEvento;

    private obi1.fi.business.to.TicketWSTO[] tickets;

    public EventoWSTO() {
    }

    public EventoWSTO(
           java.lang.String evenCdTipo,
           java.lang.String evenDhEvento,
           java.lang.String evenDsDescricao,
           java.lang.String evenDsLocal,
           java.lang.String evenDsTitulo,
           java.lang.Integer idEvenCdEvento,
           obi1.fi.business.to.TicketWSTO[] tickets) {
           this.evenCdTipo = evenCdTipo;
           this.evenDhEvento = evenDhEvento;
           this.evenDsDescricao = evenDsDescricao;
           this.evenDsLocal = evenDsLocal;
           this.evenDsTitulo = evenDsTitulo;
           this.idEvenCdEvento = idEvenCdEvento;
           this.tickets = tickets;
    }


    /**
     * Gets the evenCdTipo value for this EventoWSTO.
     * 
     * @return evenCdTipo
     */
    public java.lang.String getEvenCdTipo() {
        return evenCdTipo;
    }


    /**
     * Sets the evenCdTipo value for this EventoWSTO.
     * 
     * @param evenCdTipo
     */
    public void setEvenCdTipo(java.lang.String evenCdTipo) {
        this.evenCdTipo = evenCdTipo;
    }


    /**
     * Gets the evenDhEvento value for this EventoWSTO.
     * 
     * @return evenDhEvento
     */
    public java.lang.String getEvenDhEvento() {
        return evenDhEvento;
    }


    /**
     * Sets the evenDhEvento value for this EventoWSTO.
     * 
     * @param evenDhEvento
     */
    public void setEvenDhEvento(java.lang.String evenDhEvento) {
        this.evenDhEvento = evenDhEvento;
    }


    /**
     * Gets the evenDsDescricao value for this EventoWSTO.
     * 
     * @return evenDsDescricao
     */
    public java.lang.String getEvenDsDescricao() {
        return evenDsDescricao;
    }


    /**
     * Sets the evenDsDescricao value for this EventoWSTO.
     * 
     * @param evenDsDescricao
     */
    public void setEvenDsDescricao(java.lang.String evenDsDescricao) {
        this.evenDsDescricao = evenDsDescricao;
    }


    /**
     * Gets the evenDsLocal value for this EventoWSTO.
     * 
     * @return evenDsLocal
     */
    public java.lang.String getEvenDsLocal() {
        return evenDsLocal;
    }


    /**
     * Sets the evenDsLocal value for this EventoWSTO.
     * 
     * @param evenDsLocal
     */
    public void setEvenDsLocal(java.lang.String evenDsLocal) {
        this.evenDsLocal = evenDsLocal;
    }


    /**
     * Gets the evenDsTitulo value for this EventoWSTO.
     * 
     * @return evenDsTitulo
     */
    public java.lang.String getEvenDsTitulo() {
        return evenDsTitulo;
    }


    /**
     * Sets the evenDsTitulo value for this EventoWSTO.
     * 
     * @param evenDsTitulo
     */
    public void setEvenDsTitulo(java.lang.String evenDsTitulo) {
        this.evenDsTitulo = evenDsTitulo;
    }


    /**
     * Gets the idEvenCdEvento value for this EventoWSTO.
     * 
     * @return idEvenCdEvento
     */
    public java.lang.Integer getIdEvenCdEvento() {
        return idEvenCdEvento;
    }


    /**
     * Sets the idEvenCdEvento value for this EventoWSTO.
     * 
     * @param idEvenCdEvento
     */
    public void setIdEvenCdEvento(java.lang.Integer idEvenCdEvento) {
        this.idEvenCdEvento = idEvenCdEvento;
    }


    /**
     * Gets the tickets value for this EventoWSTO.
     * 
     * @return tickets
     */
    public obi1.fi.business.to.TicketWSTO[] getTickets() {
        return tickets;
    }


    /**
     * Sets the tickets value for this EventoWSTO.
     * 
     * @param tickets
     */
    public void setTickets(obi1.fi.business.to.TicketWSTO[] tickets) {
        this.tickets = tickets;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventoWSTO)) return false;
        EventoWSTO other = (EventoWSTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.evenCdTipo==null && other.getEvenCdTipo()==null) || 
             (this.evenCdTipo!=null &&
              this.evenCdTipo.equals(other.getEvenCdTipo()))) &&
            ((this.evenDhEvento==null && other.getEvenDhEvento()==null) || 
             (this.evenDhEvento!=null &&
              this.evenDhEvento.equals(other.getEvenDhEvento()))) &&
            ((this.evenDsDescricao==null && other.getEvenDsDescricao()==null) || 
             (this.evenDsDescricao!=null &&
              this.evenDsDescricao.equals(other.getEvenDsDescricao()))) &&
            ((this.evenDsLocal==null && other.getEvenDsLocal()==null) || 
             (this.evenDsLocal!=null &&
              this.evenDsLocal.equals(other.getEvenDsLocal()))) &&
            ((this.evenDsTitulo==null && other.getEvenDsTitulo()==null) || 
             (this.evenDsTitulo!=null &&
              this.evenDsTitulo.equals(other.getEvenDsTitulo()))) &&
            ((this.idEvenCdEvento==null && other.getIdEvenCdEvento()==null) || 
             (this.idEvenCdEvento!=null &&
              this.idEvenCdEvento.equals(other.getIdEvenCdEvento()))) &&
            ((this.tickets==null && other.getTickets()==null) || 
             (this.tickets!=null &&
              java.util.Arrays.equals(this.tickets, other.getTickets())));
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
        if (getEvenCdTipo() != null) {
            _hashCode += getEvenCdTipo().hashCode();
        }
        if (getEvenDhEvento() != null) {
            _hashCode += getEvenDhEvento().hashCode();
        }
        if (getEvenDsDescricao() != null) {
            _hashCode += getEvenDsDescricao().hashCode();
        }
        if (getEvenDsLocal() != null) {
            _hashCode += getEvenDsLocal().hashCode();
        }
        if (getEvenDsTitulo() != null) {
            _hashCode += getEvenDsTitulo().hashCode();
        }
        if (getIdEvenCdEvento() != null) {
            _hashCode += getIdEvenCdEvento().hashCode();
        }
        if (getTickets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTickets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTickets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventoWSTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://to.business.fi.obi1", "EventoWSTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evenCdTipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "evenCdTipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evenDhEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "evenDhEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evenDsDescricao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "evenDsDescricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evenDsLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "evenDsLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evenDsTitulo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "evenDsTitulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEvenCdEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "idEvenCdEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.business.fi.obi1", "tickets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://to.business.fi.obi1", "TicketWSTO"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.business.fi.obi1", "item"));
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
