package obi1.fi.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import obi1.fi.common.util.ConfigUtil;

@Controller
@RequestMapping("Rest")
@Scope("request")
public final class RestController extends AbstractController {

	public RestController() { }

	@RequestMapping("buildNumber")
	@ResponseBody
	public String buildNumber(HttpServletRequest request, String number) {
		if (number != null) ConfigUtil.buildnumber = number;
		return ConfigUtil.buildnumber;
	}

	@RequestMapping("demostep")
	@ResponseBody
	public String demostep(HttpServletRequest request, String number) {
		if (number != null) ConfigUtil.demostep = number;
		return ConfigUtil.demostep;
	}

	@RequestMapping("endpointPort")
	@ResponseBody
	public String endpointPort(HttpServletRequest request, String port) {
		if (port != null) ConfigUtil.endpointPort = port;
		return ConfigUtil.endpointPort;
	}
	
	@RequestMapping("wt")
	@ResponseBody
	public String waitTime(HttpServletRequest request, Integer time) {
		
		String result = "OK";
		
		try {
			Thread.sleep(time * 1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		
		return result;
	}

	public static void main(String[] args) {
		new RestController().runSelenium(null);
	}
	
	@RequestMapping("runSelenium")
	@ResponseBody
	public String runSelenium(HttpServletRequest request) {
		
		String result = "OK";
		//c:\\SELENIUM\\run.cmd
		 Runtime rt = Runtime.getRuntime();
		    try {
		    	rt.exec(new String[]{"cmd.exe","/c","start","c:\\SELENIUM\\run.cmd","exit"});
		    	
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
				e.printStackTrace();
				result = e.getMessage();
		    }
		return result;
	}

}
