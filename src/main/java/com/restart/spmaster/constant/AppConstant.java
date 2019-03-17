package com.restart.spmaster.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConstant {

	public static String appName;

	public static String port;

	static{
		InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
		Properties p = new Properties();
		try {
		   p.load(inputStream);
		} catch (IOException e1) {
		   e1.printStackTrace();
		}
		appName = p.getProperty("spring.application.name");
		port = p.getProperty("server.port");
	}



}
