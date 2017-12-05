package obi1.fi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import obi1.fi.common.util.ConfigUtil;

public final class GenericHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	private String strMsgError = "msgError";
	private String strBuildNumber = "buildNumber";
	private String strDemoStep = "demoStep";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (request.getSession().getAttribute(strMsgError) != null) {
			request.setAttribute(strMsgError, request.getSession().getAttribute(strMsgError));
			request.getSession().setAttribute(strMsgError, null);
		}

    	try {
			request.setAttribute(strBuildNumber, ConfigUtil.buildnumber);
			request.getSession().setAttribute(strBuildNumber, ConfigUtil.buildnumber);
			
			request.setAttribute(strDemoStep, ConfigUtil.demostep);
			request.getSession().setAttribute(strDemoStep, ConfigUtil.demostep);
    	}
    	catch (Exception x) {
    		x.printStackTrace();
    	}

		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
	//	request.getSession().setAttribute("isErrorRedirect", false);
	}

}
