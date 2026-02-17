package com.crm.horilla.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.horilla.generic.BaseClass;
import com.crm.horilla.objectRepository.CampaignPage;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.LeadsPage;
import com.crm.horilla.objectRepository.SalesPage;
import com.crm.horilla.webDriverUtility.JavaUtility;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Campaign extends BaseClass{
	WebDriverUtility wlib=new WebDriverUtility();
   JavaUtility javalib=new JavaUtility();


	@Test(groups="SmokeTesting")
	public void verifyCampaingnPage() throws Throwable
	{
		wlib.waitForPageToLoad(driver);
		HorillaHomePage homePage=new HorillaHomePage(driver);
		homePage.clicksalesLink();
		
		SalesPage salesPage=new SalesPage(driver);
		salesPage.getCampaignLink().click();
		
		CampaignPage campaignPage=new CampaignPage(driver);
		wlib.waitForUrl(driver,"campaign-view");
		String campaignTitle=campaignPage.getCampaignPageTitle().getText();
		wlib.waitForPageToLoad(driver);
		Thread.sleep(3000);
		wlib.takeScreenShot(driver, campaignTitle);
		Assert.assertEquals(campaignTitle, "Campaigns");
		UtilityClassObject.getTest().log(Status.PASS, "Campaign Page Displayed Succecfully");
		
	}
	
	
	
	
	

}
