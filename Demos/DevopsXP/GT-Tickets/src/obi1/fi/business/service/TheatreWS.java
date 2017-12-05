/**
 * TheatreWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package obi1.fi.business.service;

public interface TheatreWS extends java.rmi.Remote {
    public void performBuy(int idTicket) throws java.rmi.RemoteException;
    public obi1.fi.business.to.EventoWSTO[] findEventos(int idEvento, java.lang.String tpEvento, java.lang.String titulo) throws java.rmi.RemoteException;
}
