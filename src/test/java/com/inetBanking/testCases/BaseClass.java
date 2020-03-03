package com.inetBanking.testCases;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	//variable declaration & instantiation //
	public static WebDriver Driver;
	public static Logger logger;
	
	//Creating object to the ReadConfig.java utility file//
	ReadConfig Read_Config = new ReadConfig();
	
	//Reading variables from the config.properties files//
	public String Base_URL = Read_Config.getAppURL();
	//Reading user Credentials 
	public String Username = Read_Config.getUsername();
	public String Password = Read_Config.getPassword();
	//Reading drivers
	public String Chrome_Driver = Read_Config.getChromeDriver();
	public String Geco_Driver = Read_Config.getGecoDriver();
		
	//initiate the webdriver//
	@Parameters("browser")
	@BeforeClass
	public void setup(String Local_Browser)
	{
		
		logger = Logger.getLogger("InetBAnking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(Local_Browser.equals("ChromeDriver"))
		{
			System.setProperty("webdriver.chrome.driver",Read_Config.getChromeDriver());
			
			//ChromeOptions options = new ChromeOptions(); 
			//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			 
			Driver = new ChromeDriver();
		}
		else if(Local_Browser.equals("FireFoxDriver"))
		{
			System.setProperty("webdriver.gecko.driver", Read_Config.getGecoDriver());
			Driver = new FirefoxDriver();
		}
		

		 Driver.get(Base_URL);
		 
		 
	}

	//Close the driver//
	@AfterClass
	public void EndTest()
	{
		Driver.quit();
	}
	
	
		
	//------------------------------------//
		
		
	//Method to capture the screenshot
	public void CaptureScreenshot(WebDriver driver , String Screenshotname) throws IOException
	{ 
		TakesScreenshot Screenshot = (TakesScreenshot) driver;
		File Source = Screenshot.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+ "/Screenshots/"+Screenshotname+".png");
		FileUtils.copyFile(Source,Target);
		System.out.print("Screenshot Taken");
		
		
	}
	
}
