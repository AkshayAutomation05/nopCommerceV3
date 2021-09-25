package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.Readconfig;

public class BaseClass {
	
	Readconfig rc=new Readconfig();
	
	public String baseURL=rc.getApplicationURL();
	public String username=rc.getUser();
	public String password=rc.getPassword();
	public static WebDriver d;
	
	@Parameters("browser")
	@BeforeClass	
	public void setUp(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+rc.getChromePath());
			d=new ChromeDriver();
		}else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+rc.getFirefoxPath());
			d=new FirefoxDriver();
		}
		
	}	
	
	@AfterClass
	public void tearDown()
	{
		d.close();
	}
	
	public void captureScreen(WebDriver d, String tname) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)d;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"//Screenshots//"+tname+".png");
		//FileUtil.copyFile(source,target);
		FileHandler.copy(source,target);
		System.out.println("Screenshot captured...");
	}
	
	public static String randomString()
	{
		String random=RandomStringUtils.randomAlphabetic(5);
		return random;
	}
	
	public static void scroll(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

}
