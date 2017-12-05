package obi1.fi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import obi1.fi.web.controller.LoginController;

public final class GenericHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	@Autowired
	private AuthenticationUser authenticationUser;
	
	private String strMsgError = "msgError";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (request.getSession().getAttribute(strMsgError) != null) {
			request.setAttribute(strMsgError, request.getSession().getAttribute(strMsgError));
			request.getSession().setAttribute(strMsgError, null);
		}

		if (!(handler instanceof LoginController)) {
			authenticationUser.initAuthentication(request, response, handler);
		}

		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
	//	request.getSession().setAttribute("isErrorRedirect", false);
	}

}
