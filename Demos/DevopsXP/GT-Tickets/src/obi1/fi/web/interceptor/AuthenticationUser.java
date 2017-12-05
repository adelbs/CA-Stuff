package obi1.fi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import obi1.fi.business.to.ClienteTO;
import obi1.fi.common.exception.FiException;
import obi1.fi.common.util.FiUtils;

@Service
public final class AuthenticationUser {
	
	public void initAuthentication(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			String execaoLoginURL = "";
			String[] urlArr;
			String url;
			urlArr = request.getRequestURL().toString().split("/");
			url = urlArr[urlArr.length - 2].concat("/").concat(urlArr[urlArr.length - 1]);
			
			if (request.getSession().getAttribute("FiCdClienteCLIE") == null) {
				if (execaoLoginURL.indexOf(url) < 0) {
					if (request.getRequestURL().toString().indexOf("Home/load") < 0) {
						FiUtils.redirectPage(request, response, "/LoginWeb/logoutSess");
					}
					else {
						FiUtils.redirectPage(request, response, "/LoginWeb/logout");
					}
				}
			}
		}
		catch (Exception e) {
			throw new FiException(e);
		}
	}
	
	public void clearLogin(HttpServletRequest request) {
		request.getSession().setAttribute("FiCdClienteCLIE", null);
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response, ClienteTO clienteTO) {
		request.getSession().setAttribute("FiCdClienteCLIE", clienteTO.getEntity());
	}
	
}
