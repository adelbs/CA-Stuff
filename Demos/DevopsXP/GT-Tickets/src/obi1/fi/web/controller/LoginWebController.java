package obi1.fi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import obi1.fi.business.service.ClienteService;
import obi1.fi.business.to.ClienteTO;
import obi1.fi.business.util.TpClienteEnum;
import obi1.fi.web.exception.FiAjaxException;
import obi1.fi.web.interceptor.AuthenticationUser;

@Controller
@RequestMapping("LoginWeb")
@Scope("request")
public final class LoginWebController extends AbstractController {

	@Autowired
	private AuthenticationUser authenticationUser;

	@Autowired
	private ClienteService userService;
	
	private ClienteTO clienteTO; 
	
	public LoginWebController() {
		clienteTO = new ClienteTO();
	}

	@RequestMapping("cadastro")
	public ModelAndView cadastro(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("tiles.cadastro");
		
		clienteTO = new ClienteTO();
		model.addObject("clienteTO", clienteTO);

		return model;
	}

	//Teste
	@RequestMapping("dadosCliente")
	public ModelAndView dadosCliente(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("tiles.cadastro.consulta");
		
		clienteTO = new ClienteTO();
		clienteTO.getEntity().setId(getCurrentUser(request).getId());
		userService.fillTO(clienteTO);
		model.addObject("clienteTO", clienteTO);

		return model;
	}
	
	@RequestMapping("saveNew")
	@ResponseBody
	public String saveNew(HttpServletRequest request, HttpServletResponse response, ClienteTO clienteTO) {

		try {
			clienteTO.getEntity().setClieTpCliente(TpClienteEnum.COMUM.value);
			userService.save(clienteTO);
		}
		catch (Exception x) {
			throw new FiAjaxException(x);
		}

		return login(request, response, clienteTO);
	}

	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		return getLogout(request);
	}
	
	@RequestMapping("logoutSess")
	public ModelAndView logoutSess(HttpServletRequest request) {
		request.setAttribute("msgError", "Sua sessao expirou. Favor logar novamente.");
		return getLogout(request);
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, ClienteTO clienteTO) {
		
		try {
			this.clienteTO = userService.findFiCdClienteCLIE(clienteTO.getEntity().getClieDsLogin(), clienteTO.getEntity().getClieDsPwd());
			
			if (this.clienteTO != null) {
				authenticationUser.doLogin(request, response, this.clienteTO);
			}
			else {
				this.clienteTO = new ClienteTO();
			}
		}
		catch (Exception x) {
			throw new FiAjaxException(x);
		}

		return getEmptyJson();
	}

	private ModelAndView getLogout(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("tiles.login");
		
		clienteTO = new ClienteTO();
		model.addObject("clienteTO", clienteTO);
		
		authenticationUser.clearLogin(request);
		
		return model;
	}
	
	@ModelAttribute("clienteTO")
	public ClienteTO getClienteTO() {		
		return clienteTO;
	}

}
