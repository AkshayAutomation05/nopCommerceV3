package com.nopcommerce.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.ExcelUtil;

public class TC002_Login_DDT extends BaseClass{
	Logger logger=LogManager.getLogger(TC002_Login_DDT.class);
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws Exception
	{
		d.get(baseURL);
		d.manage().window().maximize();
		LoginPage lp=new LoginPage(d);
		logger.info("URL has been opened...");
		lp.setUserName(user);
		lp.setPassword(pwd);
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
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception
	{
		String path="E:\\Project\\TestData\\LoginData.xlsx";
		int row=ExcelUtil.getRowNumber(path, "Sheet1");
		int col=ExcelUtil.getColNumber(path,"Sheet1", row);
		System.out.println("No. of rows: "+row);
		System.out.println("No. of columns: "+col);
		
		String[][] logindata=new String[row][col];
		
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				logindata[i][j]=ExcelUtil.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}

}
