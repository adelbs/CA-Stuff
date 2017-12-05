package com.ca.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class DXUtil {

	public static String extractBody(HttpServletRequest request) throws IOException {
		StringBuilder result = new StringBuilder();
		BufferedReader reader = request.getReader();
		int readByte;
		while ((readByte = reader.read()) > -1)
			result.append(new String(new byte[]{(byte) readByte}));
		return (result.toString().equals("") ? null : result.toString());
	}

}
