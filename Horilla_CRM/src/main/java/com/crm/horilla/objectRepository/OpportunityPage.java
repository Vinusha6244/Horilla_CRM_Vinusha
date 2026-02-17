package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class OpportunityPage {
	
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public OpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Single-Step Form')]")
	private WebElement singleStepForm;
	
	@FindBy(id="id_name")
	private WebElement opportunityName;
	
	@FindBy(id="id_stage")
	private WebElement opportunityStatus;
	
	@FindBy(id="id_owner")
	private WebElement opportunityOwner;
	
	@FindBy(xpath="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[contains(text(),'Activity')]")
	private WebElement activityLink;
	
	
	@FindBy(xpath="//button[contains(text(),'Related Lists')]")
	private WebElement relatedListLink;
	
	
	@FindBy(xpath="//button[contains(text(),'History')]")
	private WebElement historyLink;
	
	@FindBy(xpath="//button[contains(text(),'Add Task')]")
	private WebElement addTaskButton;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		wlib.waitForElementPresent(driver, confirmationMessage);
		return confirmationMessage;
	}
	
	public void singleStepForm() {
		wlib.waitForElementToBeClikable(driver, singleStepForm);
		singleStepForm.click();
	}
	
	public void setOpportunityName(String name) {
		wlib.waitForElementToBeClikable(driver, opportunityName);
		opportunityName.sendKeys(name);
	}

	public void setOpportunityStatus(String status) {
		wlib.waitForElementToBeClikable(driver, opportunityStatus);
		wlib.selectByText(opportunityStatus,status);
	}
	
	public void setOpportunityOwner(String owner) {
		wlib.waitForElementToBeClikable(driver, opportunityOwner);
		wlib.selectByText(opportunityOwner,owner);
	}

	public void getSaveButton() {
		saveButton.click();
	}
	
	public void getActivityLink() {
		wlib.waitForElementToBeClikable(driver, activityLink);
		activityLink.click();
	}
	
	public void getAddTaskButton() {
		wlib.waitForElementToBeClikable(driver, addTaskButton);
		addTaskButton.click();
	}
}
