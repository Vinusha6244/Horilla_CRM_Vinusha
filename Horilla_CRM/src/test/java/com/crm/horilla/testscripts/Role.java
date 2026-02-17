package com.crm.horilla.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.horilla.fileutility.ExcelUtility;
import com.crm.horilla.generic.BaseClass;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.RolePage;
import com.crm.horilla.objectRepository.SettingsPage;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

/*AuthorName: Vinusha
 * Module Name: Role
 * testCAseNAme: Create Role*/
@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Role extends BaseClass {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility excel = new ExcelUtility();
	SoftAssert softAssert = new SoftAssert();

	@Test(groups = "IntegrationTesting")
	public void createRole() throws Throwable {
		wlib.waitForPageToLoad(driver);
		String roleName = excel.getDataFromExcel("Role", 1, 0);
		String patnerroleName = excel.getDataFromExcel("Role", 2, 1);
		String expectedSettingsTitle = excel.getDataFromExcel("ConfirmationMessage", 1, 1);
		String expectedRoleMsg = excel.getDataFromExcel("ConfirmationMessage", 2, 1);
		HorillaHomePage homePage = new HorillaHomePage(driver);
		SettingsPage settingsPage = new SettingsPage(driver);
		homePage.getSettingsIcon().click();
		String settingsTitle = settingsPage.getSettingsPageTitle().getText();
		Assert.assertEquals(settingsTitle, expectedSettingsTitle);
		UtilityClassObject.getTest().log(Status.PASS, "Settings page displayed succefully");
		settingsPage.getBaseDropDown().click();
		RolePage rolePage = new RolePage(driver);
		rolePage.getRoleLink().click();
		rolePage.getAddRoleButton().click();
		rolePage.getRoleName(roleName);
		rolePage.setPatnerRole(patnerroleName);
		rolePage.getSaveButton();
		String roleMessage = rolePage.getConfirmationMessage().getText();
		softAssert.assertEquals(roleMessage, expectedRoleMsg);
		wlib.takeScreenShot(driver, roleMessage);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,
				"Role created successfully and confirmation message displayed succefully");
		softAssert.assertAll();
	}

}
