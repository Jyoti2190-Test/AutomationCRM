package com.qa.crm.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAuthPopUp  extends TestBase{

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
	  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_D);
			r.keyPress(KeyEvent.VK_M);
			r.keyPress(KeyEvent.VK_I);
			r.keyPress(KeyEvent.VK_N);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_D);
			r.keyPress(KeyEvent.VK_M);
			r.keyPress(KeyEvent.VK_I);
			r.keyPress(KeyEvent.VK_N);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void tearDown()
	{
	 //driver.close();	
	}
}
