package obi1.fi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import obi1.fi.business.entity.FiCdUsuarioUSUA;
import obi1.fi.business.service.GenericService;
import obi1.fi.business.service.UsuarioService;
import obi1.fi.business.to.UsuarioTO;
import obi1.fi.common.exception.FiException;
import obi1.fi.common.util.Encrypt;

@Controller
@RequestMapping("Usuario")
@Scope("request")
public final class UsuarioController extends AbstractController {

	@Autowired
	private GenericService service;

	@Autowired
	private UsuarioService usuarioService;

	private UsuarioTO usuarioTO;
	
	public UsuarioController() {
		usuarioTO = new UsuarioTO();
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("tiles.adm.usuario.list");
		
		model.addObject("usuarioTO", usuarioTO);
		return model;
	}

	@RequestMapping("retrieve")
	@ResponseBody
	public String retrieve(UsuarioTO usuarioTO) {
		try {
			usuarioService.fillDataQueryBaseTO(usuarioTO);
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonResultTable(usuarioTO);
	}

	@RequestMapping("edit")
	public String edit(UsuarioTO usuarioTO) {
		usuarioService.fillTO(usuarioTO);
		
		return "tiles.adm.usuario.edit";
	}

	@RequestMapping("savepwd")
	@ResponseBody
	public String savePwd(HttpServletRequest request, HttpServletResponse response, UsuarioTO usuarioTO) {
		try {
			usuarioTO.getEntity().setUsuaDsPwd(Encrypt.encrypt(usuarioTO.getEntity().getUsuaDsLogin(), usuarioTO.getEntity().getUsuaDsPwd()));
			usuarioService.save(usuarioTO);
			
			setMessageSuccess(request, "Senha alterada com sucesso!");
		}
		catch (Exception x) {
			throw new FiException(x, "Erro salvando ao alterar senha");
		}
		//changePwd(request)
		return getJsonSuccess("system.message.senha.success");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public String save(HttpServletRequest request, UsuarioTO usuarioTO) {
		String result = getJsonSuccess("system.message.success");
		
		try {
			usuarioTO.getEntity().setUsuaDsPwd(Encrypt.encrypt(usuarioTO.getEntity().getUsuaDsLogin(), usuarioTO.getEntity().getUsuaDsPwd()));
			usuarioService.save(usuarioTO);
		}
		catch (DataIntegrityViolationException x) {
			result = getJsonError("usuarios.message.loginOuEmailDuplicado");
		}
		catch (Exception x) {
			throw new FiException(x);
		}
		
		return result;
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(HttpServletRequest request, UsuarioTO usuarioTO) {
		try {
			service.delete(usuarioTO);
		} 
		catch (DataIntegrityViolationException x) {
			throw new FiException("Este registro nao pode ser excluido pois esta sendo utilizado.");
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonSuccess("system.message.success");
	}
	
	@RequestMapping("changepwd")
	public String changePwd(HttpServletRequest request) {
		usuarioTO.setEntity((FiCdUsuarioUSUA) request.getSession().getAttribute("FiCdUsuarioUSUA"));
		return "tiles.adm.usuario.changepwd";
	}
	
	@ModelAttribute("usuarioTO")
	public UsuarioTO getUsuarioTO() {		
		return usuarioTO;
	}

}
