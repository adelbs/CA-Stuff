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

import com.ca.service.Persistense;
import com.ca.util.DXUtil;

@Controller
@RequestMapping("api")
@Scope("request")
public final class RestController {

	@RequestMapping("put")
	@ResponseBody
	public String put(HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\": \"ok\", \"message\": \"\"}";
		
		try {
			String body = DXUtil.extractBody(request);
			if (body != null)
				Persistense.put(body);
			else
				result = "{\"result\": \"error\", \"message\": \"null body\"}";
		} 
		catch (JSONException | IOException e) {
			result = "{\"result\": \"error\", \"error\": \""+ e.getMessage() +"\"}";
			e.printStackTrace();
		}
		
		return result;
	}

	@RequestMapping("get")
	@ResponseBody
	public String get(HttpServletRequest request, HttpServletResponse response) {
		String result = "[]";
		
		try {
			String body = DXUtil.extractBody(request);
			if (body != null) {
				JSONObject jsonObj = new JSONObject(body);
				result = Persistense.get(jsonObj.get("key").toString(), jsonObj.get("value").toString());
			}
			else
				result = "{\"result\": \"error\", \"message\": \"null body\"}";
		} 
		catch (JSONException | IOException e) {
			result = "{\"result\": \"error\", \"error\": \""+ e.getMessage() +"\"}";
			e.printStackTrace();
		}
		
		return result;
	}

	@RequestMapping("remove")
	@ResponseBody
	public String remove(HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\": \"ok\", \"message\": \"\"}";
		
		try {
			String body = DXUtil.extractBody(request);
			if (body != null) {
				JSONObject jsonObj = new JSONObject(body);
				int id = jsonObj.getInt("id");
				Persistense.remove(id);
			}
			else
				result = "{\"result\": \"error\", \"message\": \"null body\"}";
		} 
		catch (JSONException | IOException e) {
			result = "{result: 'error', error: '"+ e.getMessage() +"'}";
			e.printStackTrace();
		}
		
		return result;
	}

	@RequestMapping("tm")
	@ResponseBody
	public String tm(HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"message\": \"\"}";
		Persistense.clear();
		return result;
	}

	@RequestMapping("error")
	@ResponseBody
	public String error(HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"message\": \"\"}" + (12 / 0);
		return result;
	}
	
	@RequestMapping("clear")
	@ResponseBody
	public String clear(HttpServletRequest request, HttpServletResponse response) {
		String result = "{ }";
		try {
			JSONObject jsonObj = new JSONObject(DXUtil.extractBody(request));
			int time = jsonObj.getInt("time");
			String message = jsonObj.getString("message");
			Thread.sleep(time);
			result = "{\"message\": \""+ message +"\"}";
		} 
		catch (IOException | JSONException | InterruptedException e) {
			result = "{result: 'error', error: '"+ e.getMessage() +"'}";
			e.printStackTrace();
		}
		
		Persistense.clear();
		return result;
	}

}
