package obi1.fi.common.to;

import java.util.ArrayList;
import java.util.List;

import obi1.fi.common.exception.FiException;

public final class DataTableTO {

	private List<String> header;
	private List<String> fields;
	private List<Object> values;
	
	public DataTableTO(String... fields) {
		String fieldName;
		
		this.fields = new ArrayList<String>();
		this.header = new ArrayList<String>();
		
		for (String field : fields) {
			if (field.indexOf(".") > -1) {
				fieldName = field.substring(field.lastIndexOf(".") + 1);
			}
			else {
				fieldName = field;
			}
			
			this.fields.add(field);
			
			try {
				this.header.add(fieldName);
			}
			catch (Exception x) {
				this.header.add(fieldName);
			}
		}
	}
	
	public void setValues(List<Object> values) {
		try {
			//TODO colocar somente colunas que forem utilizadas
			this.values = values;
		}
		catch (Exception x) {
			throw new FiException(x);
		}
	}

	public List<Object> getValues() {
		return values;
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}
