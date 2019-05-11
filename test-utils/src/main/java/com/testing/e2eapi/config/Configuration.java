package com.testing.e2eapi.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessSecret;

	private String baseURI;
	private String basePath;
	
	private String PROD_PROPERTIES = "prod.properties";
	private String TEST_PROPERTIES = "prod.properties";
	
	Properties props = new Properties();

	public Configuration(String Env) {
		InputStream inputStream = null;
		
		if(Env.equals("Prod")|| Env.equals("prod")) 
			inputStream = getClass().getClassLoader().getResourceAsStream(PROD_PROPERTIES);
		else if(Env.equals("Test") || Env.equals("Testing")) { 
			inputStream = getClass().getClassLoader().getResourceAsStream(TEST_PROPERTIES); 
		}
		else 
			throw new IllegalArgumentException("Env can be either 'prod' or 'test");
		
		try {
			props.load(inputStream);
			
		} catch (IOException e) {
			System.out.println("inside IO Exception");
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		consumerKey = props.getProperty("consumerKey");
		consumerSecret = props.getProperty("consumerSecret");
		accessToken = props.getProperty("accessToken");
		accessSecret = props.getProperty("accessSecret");

		baseURI = props.getProperty("baseURI");
		basePath = props.getProperty("basePath");
		
	}
	public String getConsumerKey() {
		return consumerKey;
	}
	public String getConsumerSecret() {
		return consumerSecret;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public String getAccessSecret() {
		return accessSecret;
	}
	public String getBaseURI() {
		return baseURI;
	}
	public String getBasePath() {
		return basePath;
	}
	
	

}
