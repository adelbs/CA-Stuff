package com.ca.sv.ext.vse.stateless.protocol.gci.helper;

public class GCIHelper {

	final private static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static String hexToAscii(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder(n / 2);
		for (int i = 0; i < n; i += 2) {
			char a = s.charAt(i);
			char b = s.charAt(i + 1);
			sb.append((char) ((hexToInt(a) << 4) | hexToInt(b)));
		}
		return sb.toString();
	}

	private static int hexToInt(char ch) {
		if ('a' <= ch && ch <= 'f') {
			return ch - 'a' + 10;
		}
		if ('A' <= ch && ch <= 'F') {
			return ch - 'A' + 10;
		}
		if ('0' <= ch && ch <= '9') {
			return ch - '0';
		}
		throw new IllegalArgumentException(String.valueOf(ch));
	}

	public static String bytesToString(byte[] bytes) {
		String hexString = bytesToHexString(bytes);
		String asciiString = GCIHelper.hexToAscii(hexString);
		return asciiString;
	}

	public static String bytesToHexString(byte[] bytes) {  
		char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);  
	}
	
	public static String completaZeros(String num, int size) {
		String result = num;
		
		while (result.length() < size)
			result = "0"+ result;
		
		return result;
	}

}
