package com.Sakiv.Rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class RoughTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		Properties prop = new Properties();
		FileInputStream conffis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		FileInputStream objfis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\objects.properties");
		try {
			prop.load(conffis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(objfis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("bmlbtn"));
		System.out.println(prop.getProperty("appUrl"));
		System.out.println(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\screencap.jpg");
	}

}
