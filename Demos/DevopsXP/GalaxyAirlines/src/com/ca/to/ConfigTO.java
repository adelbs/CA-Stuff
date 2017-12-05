package com.ca.to;

public class ConfigTO {

	public ConfigTO(String version, String endpoint, boolean newImplementation, boolean errorNewImplementation) {
		this.version = version;
		this.endpoint = endpoint;
		this.newImplementation = newImplementation;
		this.errorNewImplementation = errorNewImplementation;
	}
	
	private String version;
	
	private String endpoint;

	private boolean newImplementation;
	
	private boolean errorNewImplementation;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public boolean isNewImplementation() {
		return newImplementation;
	}

	public void setNewImplementation(boolean newImplementation) {
		this.newImplementation = newImplementation;
	}

	public boolean isErrorNewImplementation() {
		return errorNewImplementation;
	}

	public void setErrorNewImplementation(boolean errorNewImplementation) {
		this.errorNewImplementation = errorNewImplementation;
	}
	
}
