package obi1.fi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import obi1.fi.business.service.PessoaService;
import obi1.fi.business.to.PessoaTO;
import obi1.fi.common.exception.FiException;

@Controller
@RequestMapping("Pessoa")
@Scope("request")
public class PessoaController extends AbstractController {

	@Autowired
	private PessoaService pessoaService;

	private PessoaTO pessoaTO;
	
	public PessoaController() {
		pessoaTO = new PessoaTO();
	}

	@RequestMapping("edit")
	public String edit(PessoaTO pessoaTO) {
		pessoaService.fillTO(pessoaTO);
		return "pessoa.edit";
	}

	@RequestMapping("newPessoa")
	public String newPessoa(PessoaTO pessoaTO) {
		pessoaTO.getEntity().setId(-1);
		pessoaService.fillTO(pessoaTO);
		
		if (PessoaTO.getErrorFase() == 0) {
			pessoaTO.setMessage("common.error");
		}
		
		return "pessoa.newPessoa";
	}

	@RequestMapping("save")
	@ResponseBody
	public String save(HttpServletRequest request, PessoaTO pessoaTO) {
		String result;
		
		if (PessoaTO.getErrorFase() == 0) {
			result = getJsonSuccess("ERROR!");
		}
		else {
			try {
				pessoaService.save(pessoaTO);
			}
			catch (Exception x) {
				result = getJsonSuccess(x.getMessage());
			}
			
			result = getJsonSuccess("Cadastro salvo com sucesso! Boa sorte!!!");
		}
		
		return result;
	}

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("pessoa.list");
		
		model.addObject("pessoaTO", pessoaTO);
		return model;
	}

	@RequestMapping("retrieve")
	@ResponseBody
	public String retrieve(PessoaTO pessoaTO) {
		try {
			pessoaService.fillDataQueryBaseTO(pessoaTO);
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		return getJsonResultTable(pessoaTO);
	}

	@RequestMapping("filter")
	public ModelAndView filter() {
		ModelAndView model = new ModelAndView("pessoa.filter");
		
		model.addObject("pessoaTO", pessoaTO);
		return model;
	}

	@RequestMapping("error")
	public String error(PessoaTO pessoaTO) {
		return "common.error";
	}
	
	@RequestMapping("viewData")
	public String viewData(PessoaTO pessoaTO) {
		String result;
		
		if (PessoaTO.getErrorFase() == 0) {
			result = "common.error";
		}
		else {
			this.pessoaTO = pessoaService.findFiCdPessoaPESS(pessoaTO.getPessDsEmail());
			
			if (this.pessoaTO.getQty().intValue() > 0) {
				pessoaTO.getEntity().setId(this.pessoaTO.getEntity().getId());
				pessoaTO.getEntity().setPessDsNome(this.pessoaTO.getEntity().getPessDsNome());
				pessoaTO.getEntity().setPessDsTelefone(this.pessoaTO.getEntity().getPessDsTelefone());
				pessoaTO.getEntity().setPessDsEmail(this.pessoaTO.getEntity().getPessDsEmail());
				pessoaTO.getEntity().setPessDsEmpresa(this.pessoaTO.getEntity().getPessDsEmpresa());
				pessoaTO.setQty(this.pessoaTO.getQty());
				
				pessoaTO.setMessage("Cadastrado localizado com sucesso:");
			}
			else {
				pessoaTO.setMessage("Cadastro não localizado. Verifique os dados informados e tente novamente.");
			}
			
			result = "pessoa.viewData";
		}
		
		return result;
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(HttpServletRequest request, PessoaTO pessoaTO) {
		String result = getJsonSuccess("Cadastro excluido com sucesso!");
		
		try {
			pessoaService.delete(pessoaTO);
		} 
		catch (Exception x) {
			result = getJsonSuccess(x.getMessage());
		}

		return result;
	}

	@RequestMapping("message")
	public String message(PessoaTO pessoaTO) {
		
		return "pessoa.message";
	}

}
