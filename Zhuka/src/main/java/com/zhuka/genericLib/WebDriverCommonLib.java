package com.zhuka.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;


public class WebDriverCommonLib 
{
	public String getPageTitle()
	{
		String pageTitle = BaseTest.driver.getTitle();
		return pageTitle;
		}
	public void verify(String actual,String expected,String page)
	{
		Assert.assertEquals(actual,expected);
		Reporter.log(page+"is displayed,pass",true);
	}
	public void selectOption(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	public void selectOption(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
		}
	public void selectOption(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseHover( WebElement element)
	{
		Actions ac = new Actions(BaseTest.driver);
		ac.moveToElement(element).perform();
		}
	public void rightClick( WebElement element)
	{
		Actions ac = new Actions(BaseTest.driver);
		ac.moveToElement(element).perform();
		}
	public void dragAndDropElement( WebElement source, WebElement target)
	{
		Actions ac = new Actions(BaseTest.driver);
		ac.dragAndDrop(source,target).perform();
		}
	public void switchToFrame(int index)
	{
		BaseTest.driver.switchTo().frame(index);
		}
	public void switchToFrame(String value)
	{
		BaseTest.driver.switchTo().frame(value);
		}
	public void switchToFrame(WebElement element)
	{
		BaseTest.driver.switchTo().frame(element);
		}
	public void getFullPageScreenshot(String screenshotPath)
	{
		TakesScreenshot ts =(TakesScreenshot) BaseTest.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		try
		{
			Files.copy(src,dest);
			}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}
	public void waitForPageTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,30);
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	public void getwindowHandleclick(String targetBrowserTitle , WebElement element)
	{
		String mainwindow = BaseTest.driver.getWindowHandle();
		Set<String> allwhs=BaseTest.driver.getWindowHandles();
		for(String wh:allwhs)
		{
			String title=BaseTest.driver.switchTo().window(wh).getTitle();
			if(title.equalsIgnoreCase(targetBrowserTitle))
			{
			element.click();
			}
			BaseTest.driver.switchTo().window(mainwindow);
		}
	}
	public void getwindowHandleClose(WebElement element, String targetBrowserTitle)
	{
		Set<String> allwhs=BaseTest.driver.getWindowHandles();
		for(String wh:allwhs)
		{
			String title=BaseTest.driver.switchTo().window(wh).getTitle();
			if(title.equalsIgnoreCase(targetBrowserTitle))
			{
			BaseTest.driver.close();
			}
		}
		
	}
	public void scrolldown(WebElement element)
	{
		Point location=element.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor)BaseTest.driver;
		jse.executeScript("window.scrollBy"+ location);
	}
	
	public void alertpopup()
	{
	Alert al = BaseTest.driver.switchTo().alert();
	String popupText=al.getText();
	al.accept();
	
	
	}
}
