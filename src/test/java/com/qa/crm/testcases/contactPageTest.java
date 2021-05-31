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
	
	@Test(priority=1, retryAnalyzer = Analyzer.retyAnalyzer.class)
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
		contact.selectContact("Varun Aggrawal");
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest()
	{
		contact = homePage.clickOnContactsList();	
		contact.selectContact("Varun Aggrawal");
		contact.selectContact("test test");
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=4 , dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company)
	{
		homePage.clickOnAddContactLink();
		//contact.createNewContact("Jyoti", "Singhal", "CME");
		contact.createNewContact(firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

	
}
