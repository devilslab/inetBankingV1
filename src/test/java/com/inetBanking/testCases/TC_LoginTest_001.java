package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void Login_Test() throws IOException, InterruptedException
	{ 
		
		 LoginPage Login_Page_Object = new LoginPage(Driver);
		 
		 Login_Page_Object.setUserName(Username);
		 Login_Page_Object.setPassword(Password);
		 logger.info("Username and password entered");
		 Login_Page_Object.Click_Submit();
		 logger.info("Form submitted");
		 
		 if(Driver.getTitle().equals("GTPL Bank Manager HomePage"))
		 {
			 Assert.assertTrue(true);
			 logger.info("Test case Passed");
			 //Driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) Driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 	
			 //String zoomInJS = "document.body.style.zoom='80%'";
			 Driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			 //js.executeScript(zoomInJS);
			 Driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			  Login_Page_Object.logout();
			  logger.info("log out complete");
		 }
		 else
		 {
			 Assert.assertFalse(false);
			 logger.info("Test case Failed");
			 CaptureScreenshot(Driver, "Login Test");
		 }
	}

}
