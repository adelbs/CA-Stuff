package obi1.fi.business.service;

import obi1.fi.business.to.TicketTO;

public interface TicketsService {

	void save(TicketTO ticketTO);

	void fillTO(TicketTO ticketTO);
	
	void fillDataQueryBaseTO(TicketTO ticketTO);
	
}
