package com.ca.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ca.service.PersistenseConfig;
import com.ca.to.ConfigTO;
import com.ca.util.DXUtil;

@Controller
@RequestMapping("api-config")
@Scope("request")
public final class RestConfigController {

	@RequestMapping("config")
	@ResponseBody
	public String config(HttpServletRequest request, HttpServletResponse response) {
		String result = "{ }";
		
		try {
			String body = DXUtil.extractBody(request);
			if (body != null) {
				JSONObject jsonObj = new JSONObject(body);
				PersistenseConfig.setConfigTO(new ConfigTO(
						jsonObj.getString("version"), 
						jsonObj.getString("endpoint"),
						jsonObj.getBoolean("newImplementation"),
						jsonObj.getBoolean("errorNewImplementation")));
			}
			else {
				result = new JSONObject(PersistenseConfig.getConfigTO()).toString();
			}
		} 
		catch (JSONException | IOException e) {
			result = "{\"version\": \"err\", \"error\": \""+ e.getMessage() +"\"}";
			e.printStackTrace();
		}
		
		return result;
	}

}
