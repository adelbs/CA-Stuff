package obi1.fi.web.controller;

import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import obi1.fi.business.entity.FiCdClienteCLIE;
import obi1.fi.business.entity.FiNgCompraCOMP;
import obi1.fi.business.service.CompraService;
import obi1.fi.business.service.GenericService;
import obi1.fi.business.service.TheatreWSProxy;
import obi1.fi.business.to.CompraTO;
import obi1.fi.business.to.EventoWSTO;
import obi1.fi.business.to.TicketWSTO;
import obi1.fi.business.util.TpClienteEnum;
import obi1.fi.common.exception.FiException;
import obi1.fi.common.util.ConfigUtil;
import obi1.fi.common.util.Constantes;

@Controller
@RequestMapping("Ticket")
@Scope("request")
public final class TicketController extends AbstractController {

	private EventoWSTO eventoTO;
	
	private TheatreWSProxy theatreWS;
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private GenericService gService;
	
	public TicketController() {
		eventoTO = new EventoWSTO();
		theatreWS = new TheatreWSProxy();
	}

	@RequestMapping("load")
	public ModelAndView load(HttpServletRequest request, EventoWSTO eventoTO) {
		ModelAndView model = new ModelAndView("tiles.ticketsList");
		
		this.eventoTO.setEvenCdTipo(eventoTO.getEvenCdTipo());
		this.eventoTO.setEvenDsTitulo(eventoTO.getEvenDsTitulo());
		
		return model;
	}

	@RequestMapping("sales")
	public String sales(HttpServletRequest request) {
		return "tiles.ticketsSales";
	}

	@RequestMapping("retrieveSales")
	@ResponseBody
	public String retrieveSales(HttpServletRequest request) {

		FiNgCompraCOMP[] resultList;
		
		try {
			resultList = compraService.findAll(getCurrentUser(request).getId());
		}
		catch (Exception x) {
			throw new FiException(x);
		}
		
		
		Map<String, Object> jsonMap;
		jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("result", resultList);
		return new JSONObject(jsonMap).toString();
	}
	
	@RequestMapping("retrieve")
	@ResponseBody
	public String retrieve(HttpServletRequest request, EventoWSTO eventoTO) {
		EventoWSTO[] result = null;
		String strDemoStep;
		
		try {
			result = theatreWS.findEventos(0, eventoTO.getEvenCdTipo(), eventoTO.getEvenDsTitulo());
			
			strDemoStep = ConfigUtil.demostep;

		}
		catch (Exception x) {
			throw new FiException(x);
		}

		Map<String, Object> jsonMap;
		jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("result", result);
		
		//Se for o step 2 da demo no menu cinema, tem que dar erro. Fazendo com que a app execute uma query e aparecer no cai
		if (strDemoStep.equals("2") && eventoTO.getEvenCdTipo().equals("4")) {
			compraService.findAll(1);
			return "ERROR!!!";
		}
		else
			return new JSONObject(jsonMap).toString();

	}

	@RequestMapping("buy")
	@ResponseBody
	public String buy(HttpServletRequest request, TicketWSTO ticketTO) {

		Map<String, Object> jsonMap;
		jsonMap = new LinkedHashMap<String, Object>();

		CompraTO compraTO = new CompraTO();
		GregorianCalendar cal = new GregorianCalendar();
		
		try {
			
			if (getCurrentUser(request).getClieTpCliente().intValue() == TpClienteEnum.COMUM.value && 
					compraService.findAll(getCurrentUser(request).getId()).length >= Constantes.MAX_TICKETS_COMUM_USER) {
				
				jsonMap.put("result", "MAX_TICKETS");
			}
			else {
				cal.setTimeInMillis(System.currentTimeMillis());
				
				theatreWS.performBuy(ticketTO.getIdTickCdTicket());
				compraTO.setEntity(new FiNgCompraCOMP());
				
				compraTO.getEntity().setCompDsEvento(ticketTO.getTickDsDescricao());
				compraTO.getEntity().setCompDhEvento("10/10/10");
				compraTO.getEntity().setCompDhCompra(cal.get(GregorianCalendar.DAY_OF_MONTH) +"/"+ (cal.get(GregorianCalendar.MONTH) + 1) +"/"+ cal.get(GregorianCalendar.YEAR));
				compraTO.getEntity().setCompNrValor(ticketTO.getTickNrValor());
				compraTO.getEntity().setIdTickCdTicket(ticketTO.getIdTickCdTicket());
				compraTO.getEntity().setFiCdClienteCLIE(gService.getEntity(FiCdClienteCLIE.class, getCurrentUser(request).getId()));
				
				gService.save(compraTO);
				
				jsonMap.put("result", "OK");
			}
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return new JSONObject(jsonMap).toString();
	}

	@ModelAttribute("eventoTO")
	public EventoWSTO getEventoTO() {		
		return eventoTO;
	}

}
