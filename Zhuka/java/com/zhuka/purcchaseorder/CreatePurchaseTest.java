package com.zhuka.purcchaseorder;

import org.testng.annotations.Test;


import com.zhuka.genericLib.BaseTest;
import com.zhuka.genericLib.FileLib;
import com.zhuka.genericLib.WebDriverCommonLib;
import com.zhuka.pages.CreatePurchasePage;
import com.zhuka.pages.CustomViewPage;
import com.zhuka.pages.HomePage;
import com.zhuka.pages.LoginPage;

public class CreatePurchaseTest extends BaseTest
{

	@Test
public  void purchase() throws Throwable 
{
	FileLib flib = new FileLib();
	LoginPage lp = new LoginPage();
	lp.loginToApp(flib.Readpropertydata(PROP_PATH, "username"),flib.Readpropertydata(PROP_PATH,"password"));
	WebDriverCommonLib wlib = new WebDriverCommonLib();
	wlib.verify(wlib.getPageTitle(),flib.Readpropertydata(PROP_PATH, "homeTitle"),"Home Page");
	Thread.sleep(2000);
	HomePage hp =new HomePage();
	hp.clickPurchaseTab();
	wlib.verify(wlib.getPageTitle(),flib.Readpropertydata(PROP_PATH, "customViweTitle"),"Custom View Page" );
	CustomViewPage cv = new CustomViewPage();
	cv.clickNewPurchaseTab();
	wlib.verify(wlib.getPageTitle(),flib.Readpropertydata(PROP_PATH, "createPurchaseTitle"),"Create Purchase Page");
	CreatePurchasePage cp = new CreatePurchasePage();
	cp.createPurchaseWithMandatoryDetails(flib.Readexceldata(EXCEL_PATH, "Sheet1", 0, 1)
	, flib.Readexceldata(EXCEL_PATH, "Sheet1", 1, 1),
			flib.Readexceldata(EXCEL_PATH,"Sheet1", 2, 1),flib.Readexceldata(EXCEL_PATH, "Sheet1", 3, 1));
	
			wlib.verify(wlib.getPageTitle(),flib.Readpropertydata(PROP_PATH, "purchaseorderdetailsTitle"), "Purchase detail page");
	
	
	
}
}
