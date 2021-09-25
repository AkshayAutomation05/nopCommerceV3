package com.nopcommerce.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.AddCustomer;
import com.nopcommerce.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC003_AddNewCustomer extends BaseClass{
	
	Logger logger=LogManager.getLogger(TC003_AddNewCustomer.class);
	
	@Test
	public void addCustomer() throws Exception
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
		
		logger.info("TC003_AddNewCustomer execution starts...");
		
		AddCustomer ac=new AddCustomer(d);
		ac.clickOnCustomerMenu();
		Thread.sleep(3000);
		ac.clickOnCustomerMenuItem();
		ac.clickOnAddNew();
		Thread.sleep(3000);
		
		String email=randomString()+"@gmail.com";
		ac.setEmail(email);
		
		ac.setPassword("Pass123");
		ac.setCustomerRole("Guests");
		Thread.sleep(3000);
		ac.setManagerVendor("Vendor 2");
		ac.setGender("Male");
		ac.setFirstName("Avinash");
		ac.setLastName("Patil");
		ac.dob("02/01/1990");
		ac.companyName("busyQA");
		ac.adminContent("TestDetails");
		Thread.sleep(3000);
		WebElement ele=d.findElement(By.xpath("//button[@name='save']"));
		scroll(ele);
		Thread.sleep(2000);
		ac.clickOnSave();
		
		logger.info("Validation started....");
		
		String msg=d.findElement(By.tagName("body")).getText();
		if(msg.contains("The new customer has been added successfully."))
		{
			Assert.assertTrue(true);
			logger.info("Test case passed...");
		}
		else
		{
			logger.info("Test case failed....");
			captureScreen(d,"Add New Customer");
			Assert.assertTrue(false);
		}	
		
	}

}
