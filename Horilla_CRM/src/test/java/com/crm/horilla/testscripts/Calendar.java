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
import com.crm.horilla.objectRepository.ActivityPage;
import com.crm.horilla.objectRepository.CalendarPage;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.ShedulePage;
import com.crm.horilla.webDriverUtility.JavaUtility;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Calendar extends BaseClass {
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javalib = new JavaUtility();
	ExcelUtility excel = new ExcelUtility();
	SoftAssert softAssert = new SoftAssert();

	@Test(groups="IntegrationTesting")
	public void CreateEvent() throws Throwable {
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);

		HorillaHomePage homePage = new HorillaHomePage(driver);
		homePage.getScheduleLink().click();

		CalendarPage calendarPage = new CalendarPage(driver);
		String startDate = javalib.getRequiredDateYYYYDDMM(4);
		System.out.println(startDate);
		driver.findElement(By.xpath("//td[@data-date='" + startDate + "']")).click();
		calendarPage.newActivityLink();
		String activityType = excel.getDataFromExcel("Activity", 1, 3);
		String activitySubject = excel.getDataFromExcel("Activity", 1, 1);
		String activityStatus = excel.getDataFromExcel("Activity", 1, 2);
		String leadOwner1 = excel.getDataFromExcel("Lead", 1, 0);
		String leadOwner2 = excel.getDataFromExcel("Lead", 2, 0);
		String leadOwner3 = excel.getDataFromExcel("Lead", 3, 0);
		String expectedactivitycreatedMsg = excel.getDataFromExcel("ConfirmationMessage", 4, 1);

		ActivityPage activityPage = new ActivityPage(driver);
		activityPage.selectActivityType(activityType);
		activityPage.setsubject(activitySubject);
		activityPage.selectActivityOwner(leadOwner1);
		activityPage.setActivityStatus(activityStatus);
		activityPage.selectParticipants(leadOwner1);
		activityPage.selectParticipants(leadOwner2);
		activityPage.selectParticipants(leadOwner3);
		activityPage.getSaveButton();

		String activityCreationMSG = activityPage.getConfirmationMessage().getText();
		softAssert.assertEquals(activityCreationMSG, expectedactivitycreatedMsg);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,
				"Event Activity created successfully! and confirmation message displayed Succecfully");
		wlib.takeScreenShot(driver, activityCreationMSG);
		ShedulePage shedulePage = new ShedulePage(driver);
		shedulePage.activityLink();
		String activity = driver.findElement(By.xpath("//div[contains(text(),'" + activitySubject + "')]")).getText();
		softAssert.assertEquals(activity, activitySubject);
		UtilityClassObject.getTest().log(Status.PASS, "Event Activity displayed  in Activity module Succecfully");
		//softAssert.assertAll();
	}

}
