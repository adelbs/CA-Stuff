package com.ca.sv.ext.vse.stateless.protocol.gci.to;

public class CBParameter {
	
	private String name;
	private int size;
	
	public CBParameter(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
