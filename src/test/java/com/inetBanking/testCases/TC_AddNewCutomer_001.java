package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomer;


public class TC_AddNewCutomer_001 extends BaseClass{
	
	@Test
	public void AddNewCustomer() throws IOException
	{
		LoginPage loginPageObject = new LoginPage(Driver);
		loginPageObject.setUserName(Username);
		loginPageObject.setPassword(Password);
		loginPageObject.Click_Submit();
		
		Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		NewCustomer newCustomerPage = new NewCustomer(Driver);
		newCustomerPage.OpenNewCustomerPage();
		newCustomerPage.CutomerName("Jeet");
		newCustomerPage.CustomerGender();
		newCustomerPage.CustmerDOB("03", "26", "1985");
		newCustomerPage.CustomerAddress("3850 New Janta Nagar");
		newCustomerPage.CustomerCity("Ludhiana");
		newCustomerPage.CustomerSate("Punjab");
		newCustomerPage.CustomerPin("141003");
		newCustomerPage.CustomerPhoneNo("9165988166");
		newCustomerPage.CustomerEmailId("test@test.com");
		newCustomerPage.AddNewCustomer();
		
		
		if(AlertPresent() == true)
		{
			logger.info("alert present");
		}
		else 
		{
			logger.info("No alert present");
		}
		
		
		
		
		


		
		
		
		
		
	}
	
	//Method to check the alert window
			public boolean AlertPresent()
			{
				try
				{
					Driver.switchTo().alert();
					return true;
					
				}
				catch(NoAlertPresentException e)
				{
					return false;
				}
	
	

}   
}
