package obi1.fi.web.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import obi1.fi.business.entity.FiCdPessoaPESS;
import obi1.fi.business.service.PessoaService;
import obi1.fi.business.to.PessoaTO;
import obi1.fi.common.exception.FiException;

@Controller
@RequestMapping("Sorteio")
@Scope("request")
public final class SorteioController extends AbstractController {

	private PessoaTO pessoaTO;
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping("load")
	public String load(PessoaTO pessoaTO) {
		
		return "sorteio.load";
	}
	
	@RequestMapping("retrieve")
	@ResponseBody
	public String retrieve(PessoaTO pessoaTO) {
		FiCdPessoaPESS pessoaSorteada01 = null;
		FiCdPessoaPESS pessoaSorteada02 = null;
		
		try {
			int tentatives = 0;
			
			pessoaSorteada01 = pessoaService.getWinner();
			
			do {
				pessoaSorteada02 = pessoaService.getWinner();
				tentatives++;
			} while (pessoaSorteada01.getId().intValue() == pessoaSorteada02.getId().intValue() && tentatives < 5);
			
		}
		catch (Exception x) {
			throw new FiException(x);
		}

		Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("pessoa01", pessoaSorteada01);
		jsonMap.put("pessoa02", pessoaSorteada02);
		return new JSONObject(jsonMap).toString();
	}

}
