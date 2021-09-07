package com.zhuka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zhuka.genericLib.BaseTest;

public class HomePage 
{
	@FindBy(xpath ="//body/descendant::img[@id=\"scrollright\"]") private WebElement rightBtn;

	@FindBy(xpath ="//a[text()=\"Purchase Orders\"]") private WebElement purchaseTab;

	public HomePage()
	{
		PageFactory.initElements(BaseTest.driver, this);
		}
	public void clickPurchaseTab()
	{
		for(int i=1;i<=20;i++)
		{
		rightBtn.click();

		}
		purchaseTab.click();	
	}
}
