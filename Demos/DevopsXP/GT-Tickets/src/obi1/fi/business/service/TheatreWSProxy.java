package obi1.fi.business.service;

public class TheatreWSProxy implements obi1.fi.business.service.TheatreWS {
  private String _endpoint = null;
  private obi1.fi.business.service.TheatreWS theatreWS = null;
  
  public TheatreWSProxy() {
    _initTheatreWSProxy();
  }
  
  public TheatreWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initTheatreWSProxy();
  }
  
  private void _initTheatreWSProxy() {
    try {
      theatreWS = (new obi1.fi.business.service.TheatreWSServiceLocator()).getTheatreWS();
      if (theatreWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)theatreWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)theatreWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (theatreWS != null)
      ((javax.xml.rpc.Stub)theatreWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public obi1.fi.business.service.TheatreWS getTheatreWS() {
    if (theatreWS == null)
      _initTheatreWSProxy();
    return theatreWS;
  }
  
  public void performBuy(int idTicket) throws java.rmi.RemoteException{
    if (theatreWS == null)
      _initTheatreWSProxy();
    theatreWS.performBuy(idTicket);
  }
  
  public obi1.fi.business.to.EventoWSTO[] findEventos(int idEvento, java.lang.String tpEvento, java.lang.String titulo) throws java.rmi.RemoteException{
    if (theatreWS == null)
      _initTheatreWSProxy();
    return theatreWS.findEventos(idEvento, tpEvento, titulo);
  }
  
  
}