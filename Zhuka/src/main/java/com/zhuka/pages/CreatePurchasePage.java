package com.zhuka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zhuka.genericLib.BaseTest;
import com.zhuka.genericLib.WebDriverCommonLib;
public class CreatePurchasePage 
{
	@FindBy(xpath= "//input[@name=\'property(Subject)\']") private WebElement subjectTb;
	/*@FindBy(xpath= "//img[@title=\'Vendor Name Lookup\']") private WebElement vendornamedrpdwn;
	//@FindBy(xpath="//a[text()=\"girish\"]") private WebElement girilink;
	//@FindBy(xpath="//a[text()=\"sanju\"]") private WebElement sanjulink;
	@FindBy(xpath="//a[text()=\"rashu\"]") private WebElement rashulink;
	
	@FindBy(xpath= "//input[@name=\'property(hdnProductName1)\']") private WebElement productnameTB;
	@FindBy(xpath= "//input[@name=\'property(txtQty1)\']") private WebElement qtyTb;
	@FindBy(xpath= "//input[@name=\'property(txtListPrice1)\']") private WebElement listpriceTb;*/
	@FindBy(xpath= "//input[@value=\'Save\'][1]") private WebElement saveBtn;
	
	
	public  CreatePurchasePage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	public void createPurchaseWithMandatoryDetails(String subjectName,String productName,String qty,String listPrice  ) throws Throwable
	{
		subjectTb.sendKeys("harika");
		/*vendornamedrpdwn.click();
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		//wlib.getwindowHandleclick("Zoho CRM - Vendor Name Lookup", girilink);
		//wlib.getwindowHandleclick("Zoho CRM - Vendor Name Lookup", sanjulink);
		wlib.getwindowHandleclick("Zoho CRM - Vendor Name Lookup", rashulink);
		Thread.sleep(2000);
		productnameTB.sendKeys("laddu");
		qtyTb.sendKeys("10");
		listpriceTb.sendKeys("1000");*/
		saveBtn.click();

		WebDriverCommonLib wlib= new WebDriverCommonLib();
		wlib.alertpopup();
		
		
	}
		
	}

