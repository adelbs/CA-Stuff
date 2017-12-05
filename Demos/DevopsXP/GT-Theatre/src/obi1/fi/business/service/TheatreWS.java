package obi1.fi.business.service;

import org.apache.commons.beanutils.PropertyUtils;

import obi1.fi.business.entity.FiCdTicketTICK;
import obi1.fi.business.to.EventoTO;
import obi1.fi.business.to.EventoWSTO;
import obi1.fi.business.to.TicketTO;
import obi1.fi.business.to.TicketWSTO;
import obi1.fi.business.util.AppContext;

public class TheatreWS {

	private EventosService eventoService;

	private TicketsService ticketService;
	
	private GenericService genericService;
	
/*	public EventoWSTO[] findEventos(Integer idEvento) {
		return findEventos(idEvento, null, null);
	}
	
	public EventoWSTO[] findEventos(String tpEvento, String titulo) {
		return findEventos(null, tpEvento, titulo);
	}
	
	public EventoWSTO[] findEventos(String tpEvento) {
		return findEventos(null, tpEvento, null);
	}*/
	
	public EventoWSTO[] findEventos(Integer idEvento, String tpEvento, String titulo) {

		EventoWSTO[] result = null;
		TicketWSTO[] ticketsList = null;
		
		try {
			TicketTO ticketTO;
			EventoTO eventoTO = new EventoTO();
			eventoTO.setIdEvento(idEvento);
			eventoTO.setTpEvento(tpEvento);
			eventoTO.setTitulo(titulo);
			getEventoService().fillDataQueryBaseTO(eventoTO);
			
			result = new EventoWSTO[eventoTO.getResultTable().getValues().size()];
			for (int i = 0; i < eventoTO.getResultTable().getValues().size(); i++) {
				result[i] = new EventoWSTO();
				PropertyUtils.copyProperties(result[i], eventoTO.getResultTable().getValues().get(i));
				
				ticketTO = new TicketTO();
				ticketTO.setIdEvento(result[i].getIdEvenCdEvento());
				getTicketService().fillDataQueryBaseTO(ticketTO);
				
				ticketsList = new TicketWSTO[ticketTO.getResultTable().getValues().size()];
				for (int j = 0; j < ticketTO.getResultTable().getValues().size(); j++) {
					ticketsList[j] = new TicketWSTO();
					PropertyUtils.copyProperties(ticketsList[j], ticketTO.getResultTable().getValues().get(j));
				}
				
				result[i].setTickets(ticketsList);
			}
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		
		return result;
	}
	
	public void performBuy(Integer idTicket) {
		
		try {
			FiCdTicketTICK tickEntity = getGenericService().getEntity(FiCdTicketTICK.class, idTicket);
			TicketTO tickTO = new TicketTO();
			
			tickEntity.setTickNrDisponivel(tickEntity.getTickNrDisponivel() - 1);
			tickTO.setEntity(tickEntity);
			
			getTicketService().save(tickTO);
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		
	}
	
	private EventosService getEventoService() {
		if (eventoService == null) {
			eventoService = (EventosService) AppContext.getApplicationContext().getBean(EventosService.class);
		}
		
		return eventoService;
	}
	
	private TicketsService getTicketService() {
		if (ticketService == null) {
			ticketService = (TicketsService) AppContext.getApplicationContext().getBean(TicketsService.class);
		}
		
		return ticketService;
	}

	private GenericService getGenericService() {
		if (genericService == null) {
			genericService = (GenericService) AppContext.getApplicationContext().getBean(GenericService.class);
		}
		
		return genericService;
	}

}
