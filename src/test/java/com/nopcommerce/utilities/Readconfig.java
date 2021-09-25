package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Readconfig {
	
	Properties prop;
	
	public Readconfig()
	{
		File f=new File(System.getProperty("user.dir")+"./Configuration/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(f);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getUser()
	{
		String username=prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromePath=prop.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=prop.getProperty("firefoxpath");
		return firefoxPath;
	}
	

}
