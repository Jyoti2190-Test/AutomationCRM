package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//PageFactory or Object Repository 
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement submit;
	
	@FindBy(linkText = "Sign Up")
	WebElement SignUp;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public Homepage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		
		return new Homepage();
	}
	
	
	{
		
	}
	
}
