package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	WebDriver newCustomerDriver;

	public NewCustomer(WebDriver remoteDriver)
	{
		newCustomerDriver = remoteDriver;
		PageFactory.initElements(remoteDriver,this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement NewCutomerPageLink;
	
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement customerNameTextbox;
	
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement genderRaDioButton;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement  dateOfBirth;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement addressTextArea;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement  CityTextbox;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement SateTextbox;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement stateTextbox;
	
	@FindBy(name ="pinno" )
	@CacheLookup
	WebElement pinCodeTextbox;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement telephoneNumber;
	
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement emailIdTextbox;
	
	@FindBy(xpath ="/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")
	@CacheLookup
	WebElement submitButton;
	
	public void OpenNewCustomerPage()
	{
		NewCutomerPageLink.click();
	}
	
	public void CutomerName(String Name)
	{
		customerNameTextbox.sendKeys(Name);	
	}
	
	public void CustomerGender()
	{
		genderRaDioButton.click();
	}
	
	public void CustmerDOB(String dd, String mm , String yyyy)
	{
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void CustomerAddress(String address)
	{
		addressTextArea.sendKeys(address);
	}
	
	public void CustomerCity(String city)
	{
		CityTextbox.sendKeys(city);
	}
	
	public void CustomerSate(String state)
	{
		stateTextbox.sendKeys(state);
	}
	
	public void CustomerPin(String pinCode)
	{
		pinCodeTextbox.sendKeys(pinCode);
	}
	
	public void CustomerPhoneNo(String phoneNo )
	{
		telephoneNumber.sendKeys(phoneNo);
	}
	
	public void CustomerEmailId(String Email)
	{
		emailIdTextbox.sendKeys(Email);
	}
	public void AddNewCustomer()
	{
		submitButton.click();
	}
	
}

