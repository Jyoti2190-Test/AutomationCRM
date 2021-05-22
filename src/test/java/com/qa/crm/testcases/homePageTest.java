package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class homePageTest extends TestBase{
	LoginPage loginPage;
	Homepage homePage;
	Contacts contactPage;
	public homePageTest() {
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest()
	{
		String UserNameDisplayed = homePage.verifyUserNameLabel();
		Assert.assertEquals(UserNameDisplayed, "Jyoti Singhal");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		contactPage = homePage.clickOnContactsList();
	
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
