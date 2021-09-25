package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver d;
	
	public LoginPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogOut;
	
	
	public void setUserName(String uname)
	{
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
		txtpassword.clear();
		txtpassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogOut()
	{
		lnkLogOut.click();
	}
	
	

}
