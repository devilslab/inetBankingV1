package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties property;
	
	public ReadConfig() //Constructor
	{
		File src = new File("./Configuration\\config.properties");
		try
		{
			FileInputStream fsstream = new FileInputStream(src);
			property = new Properties();
			property.load(fsstream);
						
		}
		catch(IOException e)
		{
			System.out.print("Exception is "+ e.getMessage());
			
		}
		
	}
	
	public String getChromeDriver()
	{
		String Chrome_Driver = property.getProperty("Chrome_Path");
		return Chrome_Driver;
	}
	
	public String getGecoDriver()
	{
		String Geco_Driver = property.getProperty("Firefox_Path");
		return Geco_Driver;
	}
	
	
	public String getAppURL()
	{
		String URL = property.getProperty("Base_URL");
		return URL;
	}
	
	public String getUsername()
	{
		String Username = property.getProperty("Username");
		return Username;
	}
	
	public String getPassword()
	{
		String Password = property.getProperty("Password");
		return Password;
	}
	
	
	
	
	
	
	
	
}
