package obi1.fi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import obi1.fi.business.to.PessoaTO;
import obi1.fi.test.TesteSelenium;

@Controller
@RequestMapping("Rest")
@Scope("request")
public class RestController {

	@RequestMapping("runTest")
	@ResponseBody
	public String runTest(HttpServletRequest request) {
		String result = "{'message': 'ok'}";
		
		try {
			PessoaTO.setErrorFase(PessoaTO.getErrorFase() + 1);
			TesteSelenium.runAll();
		} 
		catch (Exception x) {
			result = "{'message': '"+ x.getMessage() +"'}";
		}

		return result;
	}

	@RequestMapping("incrementErrorFase")
	@ResponseBody
	public String incrementErrorFase(HttpServletRequest request) {
		String result = "{'message': 'ok'}";
		
		try {
			PessoaTO.setErrorFase(PessoaTO.getErrorFase() + 1);
		} 
		catch (Exception x) {
			result = "{'message': '"+ x.getMessage() +"'}";
		}

		return result;
	}
	
	@RequestMapping("getErrorFase")
	@ResponseBody
	public String getErrorFase(HttpServletRequest request) {
		String result = "{'errorFase': '"+ PessoaTO.getErrorFase() +"'}";
		return result;
	}

	@RequestMapping("resetErrorFase")
	@ResponseBody
	public String resetErrorFase(HttpServletRequest request) {
		String result = "{'message': 'ok'}";
		
		try {
			PessoaTO.setErrorFase(0);
		} 
		catch (Exception x) {
			result = "{'message': '"+ x.getMessage() +"'}";
		}

		return result;
	}
	
	@RequestMapping("deploy5")
	@ResponseBody
	public String deploy5(HttpServletRequest request) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{'message': 'ok'}";
	}

	@RequestMapping("deploy3")
	@ResponseBody
	public String deploy3(HttpServletRequest request) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{'message': 'ok'}";
	}

}
