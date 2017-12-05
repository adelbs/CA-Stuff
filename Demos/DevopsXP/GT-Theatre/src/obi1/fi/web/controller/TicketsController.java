package obi1.fi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import obi1.fi.business.service.EventosService;
import obi1.fi.business.service.GenericService;
import obi1.fi.business.service.TicketsService;
import obi1.fi.business.to.TicketTO;
import obi1.fi.common.exception.FiException;

@Controller
@RequestMapping("Tickets")
@Scope("request")
public final class TicketsController extends AbstractController {

	@Autowired
	private GenericService service;

	@Autowired
	private TicketsService ticketsService;

	@Autowired
	private EventosService eventosService;
	
	private TicketTO ticketTO;
	
	public TicketsController() {
		ticketTO = new TicketTO();
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("tiles.adm.tickets.list");
		
		ticketTO.setListEventos(eventosService.findAll());
		
		model.addObject("ticketTO", ticketTO);
		return model;
	}

	@RequestMapping("retrieve")
	@ResponseBody
	public String retrieve(TicketTO ticketTO) {
		try {
			ticketsService.fillDataQueryBaseTO(ticketTO);
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonResultTable(ticketTO);
	}

	@RequestMapping("edit")
	public String edit(TicketTO ticketTO) {
		ticketsService.fillTO(ticketTO);
		
		ticketTO.setListEventos(eventosService.findAll());
		
		return "tiles.adm.tickets.edit";
	}

	@RequestMapping("save")
	@ResponseBody
	public String save(HttpServletRequest request, TicketTO ticketTO) {
		String result = getJsonSuccess("system.message.success");
		
		try {
			ticketsService.save(ticketTO);
		}
		catch (Exception x) {
			throw new FiException(x);
		}
		
		return result;
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(HttpServletRequest request, TicketTO ticketTO) {
		try {
			service.delete(ticketTO);
		} 
		catch (DataIntegrityViolationException x) {
			throw new FiException("Este registro nao pode ser excluido pois esta sendo utilizado.");
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonSuccess("system.message.success");
	}
	
	@ModelAttribute("ticketTO")
	public TicketTO getTicketTO() {		
		return ticketTO;
	}

}
