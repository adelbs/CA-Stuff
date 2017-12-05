package obi1.fi.business.util;

public enum TpCartaoEnum {

	VISA(1), MASTER(2), AMEX(3), ELO(4);
	
	public final int value;
	
	TpCartaoEnum(int value) {
		this.value = value;
	}
}
