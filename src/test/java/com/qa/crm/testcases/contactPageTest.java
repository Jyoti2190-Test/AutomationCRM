package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class contactPageTest extends TestBase {
	LoginPage loginPage;
	Homepage homePage;
	Contacts contact;
	String sheetName = "contacts";
	
	
	public contactPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
	    contact = new Contacts();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	@Test(priority=1)
	public void verifyContactLabelTest()
	{
		contact = homePage.clickOnContactsList();	
		boolean flag = contact.verifyContactLabel();
		Assert.assertTrue(flag, "contacts label is missing");
	}
	
	@Test(priority=2)
	public void selectSingleContactTest()
	{
		contact = homePage.clickOnContactsList();	
		contact.selectContact("Varun Sharma");
	}
	
	@Test(priority=3, dependsOnMethods = "selectSingleContactTest")
	public void deleteContact()
	{contact = homePage.clickOnContactsList();
	contact.deleteContact("Varun Sharma");
	boolean flag = contact.verifyContactLabel();
	Assert.assertTrue(flag, "contacts label is missing");
	}
	
	@Test(priority=4, dependsOnMethods = "selectSingleContactTest")
	public void selectMultipleContactTest()
	{
		contact = homePage.clickOnContactsList();	
		contact.selectContact("David Cris");
		contact.selectContact("test test");
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=5 , dataProvider = "getCRMTestData", enabled=true)
	public void validateCreateNewContact(String firstName, String lastName, String company)
	{
		homePage.clickOnAddContactLink();
		//contact.createNewContact("Jyoti", "Singhal", "CME");
		contact.createNewContact(firstName, lastName, company);
	}
	
	@Test(priority=6)
	public void deleteAllContats() throws InterruptedException
	{
		contact = homePage.clickOnContactsList();
		contact.alldeleteContact();
		Assert.assertEquals(contact.verifyAllContactsDeleted(),1 );
		Assert.assertEquals(contact.Warningtext(), "No records found");
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

	
}
