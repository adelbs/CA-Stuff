
package obi1.fi.test;

import obi1.fi.common.util.ConfigUtil;

public class CodigoProjeto {

    // Use to get a proxy class for TheatreWS
    private java.lang.String theatreWS_address = "http://localhost:8080/Theatre/services/TheatreWS";

    public java.lang.String getTheatreWSAddress() {
    	String value = theatreWS_address;
    	
    	try {
	    	value = ConfigUtil.endpoint +":"+ ConfigUtil.endpointPort +"/Theatre/services/TheatreWS";
    	}
    	catch (Exception x) {
    		x.printStackTrace();
    	}
    	
    	System.out.println(value);
    	return value;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TheatreWSWSDDServiceName = "TheatreWS";

    public java.lang.String getTheatreWSWSDDServiceName() {
        return TheatreWSWSDDServiceName;
    }

    public void setTheatreWSWSDDServiceName(java.lang.String name) {
        TheatreWSWSDDServiceName = name;
    }

    public obi1.fi.business.service.TheatreWS getTheatreWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(getTheatreWSAddress());
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTheatreWS(endpoint);
    }

    public obi1.fi.business.service.TheatreWS getTheatreWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            obi1.fi.business.service.TheatreWSSoapBindingStub _stub = new obi1.fi.business.service.TheatreWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getTheatreWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTheatreWSEndpointAddress(java.lang.String address) {
        theatreWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (obi1.fi.business.service.TheatreWS.class.isAssignableFrom(serviceEndpointInterface)) {
                obi1.fi.business.service.TheatreWSSoapBindingStub _stub = new obi1.fi.business.service.TheatreWSSoapBindingStub(new java.net.URL(getTheatreWSAddress()), this);
                _stub.setPortName(getTheatreWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TheatreWS".equals(inputPortName)) {
            return getTheatreWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.business.fi.obi1", "TheatreWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.business.fi.obi1", "TheatreWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TheatreWS".equals(portName)) {
            setTheatreWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
