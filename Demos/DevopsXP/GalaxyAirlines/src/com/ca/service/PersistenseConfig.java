package com.ca.service;

import com.ca.to.ConfigTO;

public class PersistenseConfig {

	private static ConfigTO configTO = new ConfigTO("220.10", "http://localhost:8082", false, false);

	public static ConfigTO getConfigTO() {
		return configTO;
	}

	public static void setConfigTO(ConfigTO configTO) {
		PersistenseConfig.configTO = configTO;
	}
	
}
