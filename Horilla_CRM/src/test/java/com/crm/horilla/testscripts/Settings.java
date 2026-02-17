package com.crm.horilla.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.horilla.fileutility.ExcelUtility;
import com.crm.horilla.generic.BaseClass;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.SettingsPage;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Settings extends BaseClass {
	WebDriverUtility wlib=new WebDriverUtility();
	 ExcelUtility excel=new ExcelUtility();
	 
	@Test(groups="SmokeTesting")
	public void verifySettingsPage() throws Throwable
	{ String expectedSettingsTitle=excel.getDataFromExcel("ConfirmationMessage", 1, 1);
		HorillaHomePage homePage=new HorillaHomePage(driver);
		homePage.getSettingsIcon().click();
		SettingsPage settingsPage=new SettingsPage(driver);
		WebElement settingsTitle=settingsPage.getSettingsPageTitle();
		wlib.waitForUrl(driver, "company-information");
		String title=settingsTitle.getText();
		wlib.takeScreenShot(driver, title);
		Assert.assertEquals(title, expectedSettingsTitle);
		UtilityClassObject.getTest().log(Status.PASS, "Settings page displayed succefully");
		
	}
	

}
