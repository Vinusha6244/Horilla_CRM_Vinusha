package com.crm.horilla.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.horilla.fileutility.ExcelUtility;
import com.crm.horilla.generic.BaseClass;
import com.crm.horilla.objectRepository.AccountPage;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.PeoplePage;
import com.crm.horilla.objectRepository.SettingsPage;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

/*AuthorName: Vinusha
 * Module Name: Account
 * testCAseNAme: Delete Account*/
@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Account extends BaseClass {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility excel = new ExcelUtility();
	SoftAssert softAssert = new SoftAssert();

	/*
	 * Create Account delete account with soft delete check in recycle bin delete
	 * from recycle bin
	 */
	@Test(groups = "SystemTesting")
	public void DeleteAccount() throws Throwable {
		wlib.waitForPageToLoad(driver);
		HorillaHomePage homePage = new HorillaHomePage(driver);
		homePage.getPeopleLink().click();
		PeoplePage peoplePage = new PeoplePage(driver);
		peoplePage.getNewButton().click();
		AccountPage accountPage = new AccountPage(driver);
		accountPage.singleStepForm();
		String accountOwner = excel.getDataFromExcel("Lead", 4, 0);
		String accountName = excel.getDataFromExcel("Lead", 3, 1);
		String industry = excel.getDataFromExcel("Lead", 4, 9);
		String accountCreatedMsg = excel.getDataFromExcel("ConfirmationMessage", 6, 1);
		String recordDeletedMsg = excel.getDataFromExcel("ConfirmationMessage", 7, 1);
		String expectedSettingsTitle = excel.getDataFromExcel("ConfirmationMessage", 1, 1);

		accountPage.setAccountOwner(accountOwner);
		accountPage.setAccountName(accountName);
		accountPage.setIndustry(industry);
		accountPage.getSaveButton();
		String confirmationMSG = accountPage.getConfirmationMessage().getText();
		Assert.assertEquals(confirmationMSG, accountCreatedMsg);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,
				"Account created successfully and confirmation message displayed Succecfully");
		wlib.takeScreenShot(driver, confirmationMSG);
		peoplePage.getAccountsLink().click();
		driver.findElement(By.xpath("//div[contains(text(),'" + accountName
				+ "')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Delete']")).click();
		accountPage.getSoftDeleteButton();
		accountPage.getConfirmDeleteButton();
		Thread.sleep(5000);
		wlib.waitFluentWait(driver);
		WebElement delete = accountPage.getConfirmationMessage();
		wlib.waitForElementPresent(driver, delete);
		String deteleConfirmationMSG = delete.getText();
		softAssert.assertEquals(deteleConfirmationMSG, recordDeletedMsg);
		UtilityClassObject.getTest().log(Status.PASS,
				"B The record was deleted successfully and confirmation message displayed Succecfully");
		wlib.takeScreenShot(driver, recordDeletedMsg);
		homePage.getSettingsIcon().click();

		SettingsPage settingsPage = new SettingsPage(driver);
		homePage.getSettingsIcon().click();
		String settingsTitle = settingsPage.getSettingsPageTitle().getText();
		Assert.assertEquals(settingsTitle, expectedSettingsTitle);
		UtilityClassObject.getTest().log(Status.PASS, "C Settings page displayed succefully");
		wlib.takeScreenShot(driver, settingsTitle);
		settingsPage.getDataManagmentDropDown().click();
		settingsPage.getRecycleBin().click();

		String recordName = settingsPage.getRecordName().getText();
		boolean value = recordName.contains(accountName);
		softAssert.assertTrue(value);
		UtilityClassObject.getTest().log(Status.PASS, "D Succefully The Softdeleted record displayed in recycle bin ");
		wlib.takeScreenShot(driver, "The record displayed in recycleBin");
		String permanentlydeletedName = settingsPage.getRecordName().getText();
		settingsPage.getRecordDeleteIcon().click();
		settingsPage.getConfirmDeleteButton().click();
		Thread.sleep(2000);
		String deletedMsg = settingsPage.getConfirmationMessage().getText();
		softAssert.assertEquals(deletedMsg, "Record '" + permanentlydeletedName + "' deleted successfully!");
		wlib.takeScreenShot(driver, permanentlydeletedName + " is deleted from recycleBin");
		UtilityClassObject.getTest().log(Status.PASS,
				"E Succefully The record deleted from recycle bin and message displayed succecfully");
		softAssert.assertAll();
	}

}
