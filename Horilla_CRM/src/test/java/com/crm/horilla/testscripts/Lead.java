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
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.LeadsPage;
import com.crm.horilla.objectRepository.SalesPage;
import com.crm.horilla.webDriverUtility.JavaUtility;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

/*AuthorName: Vinusha
 * Module Name: Lead
 * testCAseNAme: create Lead*/
@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Lead extends BaseClass {
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javalib = new JavaUtility();
	ExcelUtility excel = new ExcelUtility();
	SoftAssert softAssert = new SoftAssert();

	/*
	 * Create Lead verify confirmation message verify the lead
	 */
	@Test(groups = "IntegrationTesting")
	public void createLead() throws Throwable {
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		HorillaHomePage homePage = new HorillaHomePage(driver);
		homePage.clicksalesLink();

		SalesPage salesPage = new SalesPage(driver);
		salesPage.getLeadsLink().click();
		Thread.sleep(2000);
		salesPage.getCreateButton();

		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.singleStepForm();

		String leadOwner = excel.getDataFromExcel("Lead", 4, 0);
		String firstName = excel.getDataFromExcel("Lead", 4, 1) + javalib.getRandomNumber();
		String lastName = excel.getDataFromExcel("Lead", 4, 2);
		String email = excel.getDataFromExcel("Lead", 4, 3);
		String contactNumber = excel.getDataFromExcel("Lead", 4, 4);
		String leadSource = excel.getDataFromExcel("Lead", 4, 5);
		String leadStatus = excel.getDataFromExcel("Lead", 4, 6);
		String revenue = excel.getDataFromExcel("Lead", 4, 7);
		String company = excel.getDataFromExcel("Lead", 4, 8);
		String industry = excel.getDataFromExcel("Lead", 4, 9);
		String country = excel.getDataFromExcel("Lead", 4, 10);
		String city = excel.getDataFromExcel("Lead", 4, 11);
		String title = excel.getDataFromExcel("Lead", 1, 12);
		String leadCreatedMsg = excel.getDataFromExcel("ConfirmationMessage", 5, 1);

		leadPage.setLeadOwner(leadOwner);
		leadPage.setFirstName(firstName);
		leadPage.setLastName(lastName);
		leadPage.setTitle(title);
		leadPage.setEmail(email);
		leadPage.setContactNumber(contactNumber);
		leadPage.setLeadSource(leadSource);
		leadPage.setLeadStatus(leadStatus);
		leadPage.setLeadCompanyName(company);
		leadPage.setIndustry(industry);
		leadPage.setAnnualRevenue(revenue);
		leadPage.setCountryName(country);
		leadPage.setCity(city);
		leadPage.getSaveButton();
		String confirmationMSG = leadPage.getConfirmationMessage().getText();
		wlib.takeScreenShot(driver, confirmationMSG);
		Assert.assertEquals(confirmationMSG, leadCreatedMsg);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,
				"Lead Created succefully and confirmation message displayed Succecfully");
		salesPage.getLeadsLink().click();

		List<WebElement> actualOpportunityName = driver.findElements(
				By.xpath("//tbody[@id='data-container-leads-list']//td/div[contains(text(),'" + title + "')]"));
		for (WebElement ele : actualOpportunityName) {
			String filterName = ele.getText();
			if (filterName.equals(title)) {
				UtilityClassObject.getTest().log(Status.PASS,
						"Lead created successfully! and Succecfully displayed in Lead List page");
				ele.click();
				break;
			}
		}
	}

}
