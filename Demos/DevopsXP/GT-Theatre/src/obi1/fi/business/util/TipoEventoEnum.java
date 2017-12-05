package obi1.fi.business.util;

public enum TipoEventoEnum {

	FUTEBOL("1"),
	SHOW("2"),
	TEATRO("3"),
	CINEMA("4"),
	LUTA("5");
	
	
	String value;
	
	private TipoEventoEnum(String value) {
		this.value = value;
	}
	
}
