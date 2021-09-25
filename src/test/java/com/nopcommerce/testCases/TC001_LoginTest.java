package com.nopcommerce.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass{
		
		Logger logger=LogManager.getLogger(TC001_LoginTest.class);
	
		@Test
		public void loginTest() throws Exception
		{
			d.get(baseURL);
			d.manage().window().maximize();
			LoginPage lp=new LoginPage(d);
			logger.info("URL has been opened...");
			lp.setUserName(username);
			lp.setPassword(password);
			logger.info("Credentials have been provided...");
			lp.clickLogin();
			Thread.sleep(5000);
			logger.info("Clicked on Login button...");
			
			if(d.getTitle().equals("Dashboard / nopCommerce administration"))
			{
				Assert.assertTrue(true);
				logger.info("Page validated successfully....");
				lp.clickLogOut();
			}
			else
			{
				logger.info("Not a valid page....");
				Assert.assertTrue(false);				
			}
		
		}
		
		@AfterMethod
		public void captureScreenhot(ITestResult result) throws Exception
		{
			if(result.getStatus()==result.FAILURE)
			{
				captureScreen(d,result.getName());
			}
			
		}

}
