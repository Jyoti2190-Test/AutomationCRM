package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;import java.util.function.Function;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

import okio.Timeout;

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
	
	@FindBy(xpath="//button[@class='ui button']")
	WebElement deleteButton;
	
	@FindBy(xpath="//td[@class='right aligned collapsing options-buttons-container']//button[@class='ui icon inverted button']")
	List<WebElement> deleteAllButton;
	
	@FindBy(xpath="//div[@class='ui warning message']/div/span")
	WebElement WarningMessage;
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
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
	
	public void deleteContact(String name)
	{
		//a.moveToElement(userDisplay).build().perform();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//parent::tr//td[@class='right aligned collapsing options-buttons-container']//div[@class='contents']//button[@class='ui icon inverted button']")).click();
	    deleteButton.click();
	}
	
	public void alldeleteContact() throws InterruptedException
	{ 
		    a.moveToElement(userDisplay).build().perform();
	        List<WebElement> list = deleteAllButton;
	        for(WebElement e: list)
	        {
	        	   e = driver.findElement(By.xpath("//td[@class='right aligned collapsing options-buttons-container']//button[@class='ui icon inverted button']"));
	        	   e.click();
		           deleteButton.click();
	        }
	        a.moveToElement(userDisplay).build().perform();  
	}
	public String Warningtext()
	{
		wait.until(ExpectedConditions.textToBePresentInElement(WarningMessage, "No records found"));
		return WarningMessage.getText();
	}
	public int verifyAllContactsDeleted()
	{
		 
		 List<WebElement> list1 = driver.findElements(By.xpath("//table[@class='ui celled sortable striped table custom-grid']//tbody/tr"));
	        int size1 = list1.size();
	        return size1;	
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
