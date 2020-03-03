package com.inetBanking.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Local_Driver ;
	
	public LoginPage(WebDriver Remote_Driver)
	{
		Local_Driver = Remote_Driver;
		PageFactory.initElements(Remote_Driver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement Txt_User_Name;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Txt_Pasword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement Button_Login;

	
	
	@FindBy(xpath ="/html/body/div[3]/div/ul/li[10]/a")
	@CacheLookup
	WebElement Logout_Link;
	
	
	// functions on the page//
	
	public void setUserName(String Username)
	{
		Txt_User_Name.sendKeys(Username);
	}
	
	
	public void setPassword(String Password)
	{
		Txt_Pasword.sendKeys(Password);
	}
	
	public void Click_Submit()
	{
		Button_Login.click();
	}
	
	public void logout()
	{
		JavascriptExecutor js = (JavascriptExecutor) Local_Driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Local_Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Local_Driver.manage().window().maximize();
		
		//js.executeScript("arguments[0].Click", Logout_Link);
		
		
		
	    
		Actions act = new Actions(Local_Driver);
		act.moveToElement(Logout_Link).click().build().perform();
		WebElement logOutLink = Logout_Link;
		logOutLink.click();
	
		System.out.print("log out ho gaya");
			
			
		//Logout_Link.click();
	}
	
	
	
	
	
	
	
	
	
	
}
