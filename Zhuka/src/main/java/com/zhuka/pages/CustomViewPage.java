package com.zhuka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zhuka.genericLib.BaseTest;
public class CustomViewPage
{
	@FindBy(xpath ="//input[@value= \'New Purchase Order\']") private WebElement newPurchaseBtn;
	public CustomViewPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
		}
	public void clickNewPurchaseTab()
	{
		newPurchaseBtn.click();
	}

}
