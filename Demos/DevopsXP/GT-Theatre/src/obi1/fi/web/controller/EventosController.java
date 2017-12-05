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
import obi1.fi.business.to.EventoTO;
import obi1.fi.common.exception.FiException;

@Controller
@RequestMapping("Eventos")
@Scope("request")
public final class EventosController extends AbstractController {

	@Autowired
	private GenericService service;

	@Autowired
	private EventosService eventosService;

	private EventoTO eventoTO;
	
	public EventosController() {
		eventoTO = new EventoTO();
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("tiles.adm.eventos.list");
		
		model.addObject("eventoTO", eventoTO);
		return model;
	}

	@RequestMapping("retrieve")
	@ResponseBody
	public String retrieve(EventoTO eventoTO) {
		try {
			eventosService.fillDataQueryBaseTO(eventoTO);
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonResultTable(eventoTO);
	}

	@RequestMapping("edit")
	public String edit(EventoTO eventoTO) {
		eventosService.fillTO(eventoTO);
		
		return "tiles.adm.eventos.edit";
	}

	@RequestMapping("save")
	@ResponseBody
	public String save(HttpServletRequest request, EventoTO eventoTO) {
		String result = getJsonSuccess("system.message.success");
		
		try {
			eventosService.save(eventoTO);
		}
		catch (Exception x) {
			throw new FiException(x);
		}
		
		return result;
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(HttpServletRequest request, EventoTO eventoTO) {
		try {
			service.delete(eventoTO);
		} 
		catch (DataIntegrityViolationException x) {
			throw new FiException("Este registro nao pode ser excluido pois esta sendo utilizado.");
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonSuccess("system.message.success");
	}

	@ModelAttribute("eventoTO")
	public EventoTO getEventoTO() {		
		return eventoTO;
	}

}
