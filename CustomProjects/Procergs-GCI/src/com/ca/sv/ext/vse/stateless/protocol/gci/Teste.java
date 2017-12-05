package com.ca.sv.ext.vse.stateless.protocol.gci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Teste {

	private String CONFIG_DIR = "C:\\CA\\DevTest8\\Projects\\ProcergsGCI\\Data\\config";

	
	private String parseCustomCmds(String text) {
		
		String result = text;
		
		try {
			if (result.indexOf("{{autoSequence") > -1) {
				String key = result.substring(result.indexOf("{{autoSequence") + 15, result.indexOf(")", result.indexOf("{{autoSequence")));
				String nextNumber;
				String minChar;
				
				Properties prop = new Properties();
				OutputStream output = null;
				InputStream input = new FileInputStream(CONFIG_DIR + File.separator + "autoSequence.properties");
				
				prop.load(input);
				nextNumber = prop.getProperty(key);
				minChar = prop.getProperty(key +".minChar");
				
				if (nextNumber == null)
					nextNumber = "1";
				
				if (minChar == null)
					minChar = "1";
				
				//USAR O NUMERO
				nextNumber = completaZeros(nextNumber, Integer.parseInt(minChar));
				result = result.substring(0, result.indexOf("{{autoSequence")) + 
						nextNumber + result.substring(result.indexOf(")", result.indexOf("{{autoSequence")) + 3);
				
				output = new FileOutputStream(CONFIG_DIR + File.separator + "autoSequence.properties");
				nextNumber = String.valueOf(Integer.parseInt(nextNumber) + 1);
				prop.setProperty(key, nextNumber);
				prop.setProperty(key +".minChar", minChar);
				prop.store(output, null);
			}
		}
		catch(Exception x) {
			x.printStackTrace();
		}
		
		return result;
	}

	private String completaZeros(String num, int size) {
		String result = num;
		
		while (result.length() < size)
			result = "0"+ result;
		
		return result;
	}

	public static void main(String[] args) {
		String texto = "Numero = {{autoSequence(alo)}}";
		texto = new Teste().parseCustomCmds(texto);
		System.out.println(texto);
	}
}
