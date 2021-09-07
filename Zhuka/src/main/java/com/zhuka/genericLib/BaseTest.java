package com.zhuka.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseTest implements  IAutoConsts 
{
	public static WebDriver driver;
	@BeforeClass 
	public void openBrowser() throws Throwable
	{
		FileLib flib = new FileLib();
		String browserName = flib.Readpropertydata(PROP_PATH, "browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
				{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
	}
		else
		{
			System.out.println("enter proper browser name");
		}
		driver.manage().window().maximize();
		String appURL = flib.Readpropertydata(PROP_PATH, "url");
		driver.get(appURL);
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		String expectedLoginTitle= flib.Readpropertydata(PROP_PATH, "loginTitle");
		wlib.verify(wlib.getPageTitle(), expectedLoginTitle, "Login Page");
		}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
