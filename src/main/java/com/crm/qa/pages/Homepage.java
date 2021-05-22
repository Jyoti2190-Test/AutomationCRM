package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage  extends TestBase{
	@FindBy(xpath="//span[@class='user-display']")
	 WebElement userDisplay;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement Contacts;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Deals;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Tasks;
	Actions a = new Actions(driver);
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]//parent::a/following-sibling::button")
	WebElement ContactAdd;

	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public Contacts clickOnContactsList()
	{
		a.moveToElement(Contacts).build().perform();
		Contacts.click();
		return new Contacts();	
	}
	
	public Deal clickOnDealsLink()
	{
		a.moveToElement(Deals).build().perform();
		Deals.click();
		return new Deal();
	}
	
	public Tasks clickOnTasksLink()
	{
		a.moveToElement(Deals).build().perform();
		Deals.click();
		return new Tasks();
	}
	
	public String verifyUserNameLabel()
	{
	     return userDisplay.getText();
	}
	
	public void clickOnAddContactLink()
	{
		a.moveToElement(Contacts).build().perform();
		ContactAdd.click();
		a.moveToElement(userDisplay).build().perform();		 
	}
	
	
	
	 
	

}
