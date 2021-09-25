package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

	public WebDriver d;
	
	public AddCustomer(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	By lnkCustomers=By.xpath("//i[@class='nav-icon far fa-user']");
	By lnkCustomerItem=By.xpath("//a[contains(@href,'/Customer/List')]/p");
	By btnAddCustomer=By.xpath("//a[contains(@href,'/Customer/Create')]");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtfirstName=By.xpath("//input[@id='FirstName']");
	By txtlastName=By.xpath("//input[@id='LastName']");
	By rdgenderMale=By.xpath("//input[@id='Gender_Male']");
	By rdgenderFemale=By.xpath("//input[@id='Gender_Female']");
	By txtDOB=By.xpath("//input[@id='DateOfBirth']");
	By txtcompanyName=By.xpath("//input[@id='Company']");
	By chktaxExempt=By.xpath("//input[@id='IsTaxExempt']");
	By txtCustomerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstGuest=By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']/li[text()='Guests']");
	By drdvendorId=By.xpath("//*[@id='VendorId']");
	By txtadminComment=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");
	
	public void clickOnCustomerMenu()
	{
		d.findElement(lnkCustomers).click();
	}
	
	public void clickOnCustomerMenuItem()
	{
		d.findElement(lnkCustomerItem).click();
	}
	
	public void clickOnAddNew()
	{
		d.findElement(btnAddCustomer).click();
	}
	
	public void setEmail(String email)
	{
		d.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		d.findElement(txtPassword).sendKeys(pwd);
	}
	
	
	public void setCustomerRole(String role)
	{
		d.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		d.findElement(txtCustomerRole).click();
		WebElement listItem;
		
		switch(role)
		{
		case "Guests":
			listItem=d.findElement(lstGuest);
			break;
			
			default:
				listItem=d.findElement(lstGuest);
				break;				
		
		}
		
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].click();",listItem);		
	}
	
	public void setManagerVendor(String vendor)
	{
		Select sel=new Select(d.findElement(drdvendorId));
		sel.selectByVisibleText(vendor);
		
	}
	public void setGender(String gen)
	{
		if(gen.equals("Male"))
		{
			d.findElement(rdgenderMale).click();
		}
		else if(gen.equals("Female"))
		{
			d.findElement(rdgenderFemale).click();
		}else
		{
			d.findElement(rdgenderMale).click();
		}
	}
	
	public void setFirstName(String fname)
	{
		d.findElement(txtfirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		d.findElement(txtlastName).sendKeys(lname);
	}
	
	public void dob(String dob)
	{
		d.findElement(txtDOB).sendKeys(dob);
	}
	
	public void companyName(String cmp)
	{
		d.findElement(txtcompanyName).sendKeys(cmp);
	}
	
	public void adminContent(String comm)
	{
		d.findElement(txtadminComment).sendKeys(comm);
	}
	
	public void scroll()
	{
		d.findElement(btnSave);
	}
	
	public void clickOnSave()
	{
		d.findElement(btnSave).click();
	}
	
	
}
