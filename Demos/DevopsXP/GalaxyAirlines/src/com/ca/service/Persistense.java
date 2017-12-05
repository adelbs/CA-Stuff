package com.ca.service;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Persistense {

	private static ArrayList<String> values = new ArrayList<String>();
	
	public static void put(String json) throws JSONException {
		JSONObject jsonObj = new JSONObject(json);
		int id = (int) jsonObj.get("id");
		int index = getIndexOf(id);
		
		if (index < 0) {
			jsonObj.put("id", getNextId());
			values.add(jsonObj.toString());
		}
		else {
			values.add(index, json);
		}
	}
	
	private static int getNextId() throws JSONException {
		JSONObject jsonObj;
		int nextId = 0;
		int id;
		for (String value : values) {
			jsonObj = new JSONObject(value);
			id = (int) jsonObj.get("id");
			nextId = (nextId > id ? nextId : id);
		}
		
		return nextId + 1;
	}
	
	public static String get(int id) throws JSONException {
		int index = getIndexOf(id);
		String result = null;
		if (index > 0)
			result = values.get(index);
		return result;
	}

	private static int getIndexOf(int id) throws JSONException {
		JSONObject jsonObj;
		int objId;
		int result = -1;
		for (int i = 0; i < values.size(); i++) {
			jsonObj = new JSONObject(values.get(i));
			objId = (int) jsonObj.get("id");
			if (objId == id) {
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	public static String get(String key, String value) throws JSONException {
		JSONObject jsonObj;
		ArrayList<String> resultList = new ArrayList<String>();
		String result;
		
		for (String objValue : values) {
			jsonObj = new JSONObject(objValue);
			if (jsonObj.get(key) != null && jsonObj.get(key).toString().toLowerCase().indexOf(value.toLowerCase()) >= 0)
				resultList.add(objValue);
		}
		
		result = "[ ";
		for (String objValue : resultList)
			result += objValue + ",";
		result = result.substring(0, result.length() - 1) + "]";
		
		return result;
	}
	
	public static void remove(int id) throws JSONException {
		int index = getIndexOf(id);
		if (index > 0)
			values.remove(index);
	}
	
	public static void clear() {
		values.clear();
	}
}
