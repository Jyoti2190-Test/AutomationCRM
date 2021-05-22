package com.crm.qa.pages;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class Contacts extends TestBase{
	
	Actions a = new Actions(driver);
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//span[@class='user-display']")
	 WebElement userDisplay;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveButton;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement Company;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement verifyContact;
	
	
	public Contacts()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel()
	{   a.moveToElement(userDisplay).build().perform();
		return ContactsLabel.isDisplayed();
	}
	
	public void selectContact(String name)
	{
		a.moveToElement(userDisplay).build().perform();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td")).click();
	}
	
	public void createNewContact(String ftName, String LtName, String company)
	{
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(firstName)); 
		firstName.sendKeys(ftName);
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(LtName);
		wait.until(ExpectedConditions.elementToBeClickable(Company));
		Company.sendKeys(company);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		SaveButton.click();
		wait.until(ExpectedConditions.textToBePresentInElement(verifyContact, ftName + " " + LtName));
		Assert.assertEquals(ftName + " " + LtName, verifyContact.getText());
	}
	

}
