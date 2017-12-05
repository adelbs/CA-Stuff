package com.ca.sv.ext.vse.stateless.protocol.gci.to;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ca.sv.ext.vse.stateless.protocol.gci.helper.LinkedProperties;

public class CopyBook {
	
	private CopyBook() {}

	private List<CBParameter> parameters;
	
	private String name;
	
	private int size;
	
	public static CopyBook getInstance(LinkedProperties prop) {
		CopyBook copyBook = new CopyBook();
		copyBook.parameters = new ArrayList<CBParameter>();
		copyBook.name = prop.getProperty("OPP_NAME");
		
		Iterator<Object> elements = prop.orderedKeys().iterator();
		String key;
		while (elements.hasNext()) {
			key = (String) elements.next();
			
			if (!key.equals("KEY") && !key.equals("OPP_NAME")) {
				int size = Integer.parseInt(prop.getProperty(key));
				copyBook.parameters.add(new CBParameter(key, size));
				copyBook.size += size;
			}
		}
		
		return copyBook;
	}

	public List<CBParameter> getParameters() {
		return parameters;
	}

	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
}
