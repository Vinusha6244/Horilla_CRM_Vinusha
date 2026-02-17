package com.crm.horilla.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.horilla.fileutility.ExcelUtility;
import com.crm.horilla.generic.BaseClass;
import com.crm.horilla.objectRepository.ActivityPage;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.OpportunityPage;
import com.crm.horilla.objectRepository.SalesPage;
import com.crm.horilla.webDriverUtility.JavaUtility;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

/*AuthorName: Vinusha
 * Module Name:Opportunities
 * testCAseNAme:createOpportinityandAddTask*/
@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Opportunity extends BaseClass {
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javalib = new JavaUtility();
	ExcelUtility excel = new ExcelUtility();
	SoftAssert softAssert = new SoftAssert();

	/* create Opportunity 
	 * create task 
	 * check that task*/
	@Test(groups="SystemTesting")
	public void CreateOpportunityandaddtask() throws Throwable {
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		HorillaHomePage homePage = new HorillaHomePage(driver);
		homePage.clicksalesLink();

		SalesPage salesPage = new SalesPage(driver);
		salesPage.getOpportunityLink().click();
		wlib.waitForUrl(driver, "opportunities-view");
		salesPage.getCreateButton();
		OpportunityPage oppoPage = new OpportunityPage(driver);
		oppoPage.singleStepForm();

		String name = excel.getDataFromExcel("Opportunity", 1, 0);
		String status = excel.getDataFromExcel("Opportunity", 2, 1);
		String owner = excel.getDataFromExcel("Opportunity", 4, 2);
		String activityTitle = excel.getDataFromExcel("Activity", 1, 0);
		String activitySubject = excel.getDataFromExcel("Activity", 1, 1);
		String activityStatus = excel.getDataFromExcel("Activity", 1, 2);
		String expectedopportunitycreatedMsg = excel.getDataFromExcel("ConfirmationMessage", 3, 1);
		String activityMsg = excel.getDataFromExcel("ConfirmationMessage", 4, 1);

		oppoPage.setOpportunityName(name);
		oppoPage.setOpportunityStatus(status);
		oppoPage.setOpportunityOwner(owner);
		oppoPage.getSaveButton();
		String confirmationMSG = oppoPage.getConfirmationMessage().getText();
		softAssert.assertEquals(confirmationMSG, expectedopportunitycreatedMsg);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,
				"Opportunity created successfully! and confirmation message displayed Succecfully");
		wlib.takeScreenShot(driver, confirmationMSG);
		salesPage.getOpportunityLink().click();

		List<WebElement> actualOpportunityName = driver.findElements(By
				.xpath("//tbody[@id='data-container-opportunity-container']//td/div[contains(text(),'" + name + "')]"));
		for (WebElement ele : actualOpportunityName) {
			String filterName = ele.getText();
			if (filterName.equals(name)) {
				UtilityClassObject.getTest().log(Status.PASS,
						"Opportunity created successfully! and Succecfully displayed in opportunityList page");
				wlib.takeScreenShot(driver, name+" succecfully displayed");
				ele.click();
				break;
			}
		}

		oppoPage.getActivityLink();
		Thread.sleep(2000);
		wlib.waitForUrl(driver, "opportunity-detail-view");
		oppoPage.getAddTaskButton();
		ActivityPage activity = new ActivityPage(driver);
		activity.setTitle(activityTitle);
		activity.setsubject(activitySubject);
		activity.setActivityStatus(activityStatus);
		activity.getSaveButton();
		String activityConfirmationMSG = activity.getConfirmationMessage().getText();
		softAssert.assertEquals(activityConfirmationMSG, activityMsg);
		UtilityClassObject.getTest().log(Status.PASS,
				"Activity created successfully! and confirmation message displayed Succecfully");
		wlib.takeScreenShot(driver, activityConfirmationMSG);
		softAssert.assertAll();
	}

}
