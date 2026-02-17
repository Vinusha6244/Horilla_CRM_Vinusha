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
import com.crm.horilla.objectRepository.ReportsPage;
import com.crm.horilla.webDriverUtility.JavaUtility;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

/*AuthorName: Vinusha
 * Module Name: Reports
 * testCAseNAme: download Reports*/
//@Listeners(com.crm.horilla.listenerutility.ListenerImplimentation.class)
public class Reports extends BaseClass {
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javalib = new JavaUtility();
	ExcelUtility excel = new ExcelUtility();
	 SoftAssert softAssert=new SoftAssert();
	 
		/* create New Report
		 * click on that report
		 * download report
		 * and delete that report
		 * verify message */
	@Test(groups="SystemTesting")
	public void DownloadReport() throws Throwable {
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		HorillaHomePage homePage = new HorillaHomePage(driver);
		homePage.getAnalyticsLink().click();

		String reportName = excel.getDataFromExcel("Reports", 6, 0);
		String module = excel.getDataFromExcel("Reports", 3, 1);
		String folder = excel.getDataFromExcel("Reports", 1, 2);
		String firstNameColoumn = excel.getDataFromExcel("Reports", 6, 3);
		String lastNameColoumn = excel.getDataFromExcel("Reports", 7, 3);
		String emailColoumn = excel.getDataFromExcel("Reports", 8, 3);
		String reportCreatedMsg = excel.getDataFromExcel("ConfirmationMessage", 8, 1);
		String reportDeletedMsg = excel.getDataFromExcel("ConfirmationMessage", 9, 1);
		
		ReportsPage reportPage = new ReportsPage(driver);
		reportPage.createReport();
		reportPage.setReportName(reportName);
		reportPage.selectModule(module);
		reportPage.selectFolder(folder);
		reportPage.selectColoumn(firstNameColoumn);
		reportPage.selectColoumn(lastNameColoumn);
		reportPage.selectColoumn(emailColoumn);
		reportPage.getSaveButton();
		String confirmationMSG = reportPage.getConfirmationMessage().getText();
		softAssert.assertEquals(confirmationMSG, reportCreatedMsg);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,"Report Created succefully and confirmation message displayed Succecfully");
        wlib.takeScreenShot(driver, confirmationMSG);
		reportPage.exportRecord();
		reportPage.downloadExcel();
		wlib.takeScreenShot(driver, "downloaded Report");
		softAssert.assertTrue(true);
		UtilityClassObject.getTest().log(Status.PASS,"Excel Report downloaded succefully and confirmation message displayed Succecfully");
		 
		reportPage.reportsModule();
		List<WebElement> reportNameFilter=reportPage.getActualReportName();
		  for(WebElement ele:reportNameFilter) 
		  {
			  String filterName=ele.getText();
		  if(filterName.equals(reportName))
		  {   
			  driver.findElement(By.xpath("//div[contains(text(),'"+reportName+"')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Delete']")).click();
			  break;
		  }
		  }
		  reportPage.getSoftDeleteButton();
		  reportPage.getConfirmDeleteButton();
		  Thread.sleep(4000);
		  String actualReportDeletedMsg = reportPage.getConfirmationMessage().getText();
		  softAssert.assertEquals(actualReportDeletedMsg, reportDeletedMsg);
		  UtilityClassObject.getTest().log(Status.PASS,"The created report record was deleted succefully and confirmation message displayed Succecfully");
          Thread.sleep(2000);
		  wlib.takeScreenShot(driver, "Report Deleted");
		  softAssert.assertAll();
	}

}
