package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static String getBrowserName() {
		String base = System.getProperty("user.dir");
		String filepath = base + "/src/main/resources/application.properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value = prop.getProperty("browser_Name");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public static String getAppUrl() {
		String base = System.getProperty("user.dir");
		String filepath = base + "/src/main/resources/application.properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		String url = null;
		try {
			prop.load(fis);
			url = prop.getProperty("app.url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

}
