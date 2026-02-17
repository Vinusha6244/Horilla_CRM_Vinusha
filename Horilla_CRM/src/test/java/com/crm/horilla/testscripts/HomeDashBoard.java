package com.crm.horilla.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.horilla.fileutility.ExcelUtility;
import com.crm.horilla.generic.BaseClass;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class HomeDashBoard extends BaseClass {
	WebDriverUtility wlib=new WebDriverUtility();
	 ExcelUtility excel=new ExcelUtility();
	 
	@Test(groups="SmokeTesting")
	public void verifyDashBoardPage() throws Throwable
	{
		HorillaHomePage homePage=new HorillaHomePage(driver);
		String homeTitle=homePage.getHomeDashBoard().getText();
		wlib.takeScreenShot(driver, "WelCome  DashBoard Page");
		boolean actualTitle=homeTitle.contains("Welcome");
		Assert.assertEquals(actualTitle, true);
		UtilityClassObject.getTest().log(Status.PASS, "DashBoard page loaded succefully");
	}

}
