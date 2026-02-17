package com.crm.horilla.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class ReportsPage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public ReportsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="reports")
	private WebElement reportsModule;
	
	@FindBy(id="report-create")
	private WebElement createReport;
	
	@FindBy(id="id_name")
	private WebElement reportName;
	
	@FindBy(id="id_module")
	private WebElement module;
	
	@FindBy(id="id_folder")
	private WebElement folder;

	@FindBy(id="id_columns")
	private WebElement coloumn;
	
	@FindBy(xpath="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	
	@FindBy(xpath="//tbody[@id='data-container-reports-list']//td")
	private List<WebElement> actualReportName;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	@FindBy(id="exportDropdownButton")
	private WebElement exportRecord;
	
	@FindBy(xpath="//div[@id='exportDropdown']//a")
	private WebElement downloadExcel;
	
	@FindBy(xpath="//span[@id='soft-delete-spinner']/..")
	private WebElement softDeleteButton;
	
	@FindBy(xpath="//span[@id='confirm-delete-spinner']/..")
	private WebElement confirmDeleteButton;
	
	
	public void reportsModule() {
		wlib.waitForElementToBeClikable(driver, reportsModule);
		reportsModule.click();
	}
	
	public WebElement getConfirmationMessage() {
		wlib.waitForElementPresent(driver, confirmationMessage);
		return confirmationMessage;
	}
	
	public List<WebElement> getActualReportName() {
		return actualReportName;
	}
	
	public void createReport() {
		wlib.waitForElementToBeClikable(driver, createReport);
		createReport.click();
	}
	public void downloadExcel() {
		wlib.waitForElementToBeClikable(driver, downloadExcel);
		downloadExcel.click();
	}
	
	public void exportRecord() {
		wlib.waitForElementToBeClikable(driver, exportRecord);
		exportRecord.click();
	}
	
	public void setReportName(String name) {
		wlib.waitForElementToBeClikable(driver, reportName);
		reportName.sendKeys(name);
	}
	
	public void selectModule(String moduleName) {
		wlib.waitForElementToBeClikable(driver, module);
		wlib.selectByText(module,moduleName);
	}
	
	public void selectColoumn(String coloumnName) {
		wlib.waitForElementToBeClikable(driver, coloumn);
		wlib.selectByText(coloumn,coloumnName);
	}
	public void selectFolder(String folderName) {
		wlib.waitForElementToBeClikable(driver, folder);
		wlib.selectByText(folder,folderName);
	}
	
	public void getSaveButton() {
		wlib.waitForElementToBeClikable(driver, saveButton);
		saveButton.click();
	}
	
	public void getSoftDeleteButton() {
		wlib.waitForElementToBeClikable(driver, softDeleteButton);
		softDeleteButton.click();
	}
	
	public void getConfirmDeleteButton() {
		wlib.waitForElementToBeClikable(driver, confirmDeleteButton);
		confirmDeleteButton.click();
	}
}
