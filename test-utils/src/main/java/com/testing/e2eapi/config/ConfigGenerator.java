package com.testing.e2eapi.config;

public enum ConfigGenerator {
	
	INSTANCE;
	
	private Configuration config=null;
	
	private ConfigGenerator () {
		String env = System.getenv("ENV_NAME");
		if(env == null)
			config = new Configuration("Test");
		else
			config = new Configuration(env);
	}
	
	public Configuration getConfiguration() {
		return config;
	}

}
