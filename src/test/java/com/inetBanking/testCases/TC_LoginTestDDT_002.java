package com.inetBanking.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelReaderUtil;

public class TC_LoginTestDDT_002 extends BaseClass
{
	
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user_name , String Pwd) throws InterruptedException
	{
		LoginPage lp = new  LoginPage(Driver);
		
		lp.setUserName(user_name);
		logger.info("Username entered");
		lp.setPassword(Pwd);
		logger.info("Password entered");
		logger.info(user_name +" " +Pwd);
		lp.Click_Submit();
		Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.info("Credential entered");
		//lp.logout();
		
		/*if(AlertPresent()== true)
		{
			logger.info("alert present");
			Driver.switchTo().alert().accept();//Closing incorrect password alert
			Driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login successful");
			Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			lp.logout();
			logger.info("logout done");
			Driver.switchTo().alert().accept();//Closing logout alert
			Driver.switchTo().defaultContent();
			
		}*/
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
		
	@DataProvider(name = "LoginData")
	String[][] GetData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int Rownum =  ExcelReaderUtil.getRowCount(path, "Sheet1");
		int Colnum = ExcelReaderUtil.getCellCount(path, "Sheet1",1);
		
		String Data[][] = new String[Rownum][Colnum];
		
		for(int i =1; i<=Rownum ; i++)
		{
			for (int j=0 ; j< Colnum ; j++)
			{
				Data[i-1][j] = ExcelReaderUtil.getCellData(path, "sheet1", i, j);
			}
			
		}
		return Data;
		
	}
}
