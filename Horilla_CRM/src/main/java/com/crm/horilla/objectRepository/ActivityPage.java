package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class ActivityPage {
	
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public ActivityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_title")
	private WebElement title;
	
	@FindBy(id="id_activity_type")
	private WebElement activityType;
	
	@FindBy(id="id_subject")
	private WebElement subject;
	
	@FindBy(id="id_owner")
	private WebElement activityOwner;
	
	
	@FindBy(id="id_status")
	private WebElement activityStatus;
	
	@FindBy(id="id_due_datetime")
	private WebElement date;
	
	@FindBy(id="id_participants")
	private WebElement participants;
	
	@FindBy(xpath="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		wlib.waitForElementToBeClikable(driver, confirmationMessage);
		return confirmationMessage;
	}
	
	public void setTitle(String name) {
		wlib.waitForElementToBeClikable(driver, title);
		title.sendKeys("opportunityTask");
	}

	public void selectActivityOwner(String ownerName) { 
		wlib.selectByText(activityOwner,ownerName);
	}
	
	public void selectParticipants(String participantsName) { 
		wlib.waitForElementToBeClikable(driver, participants);
		wlib.selectByText(participants,participantsName);
	}
	
	public void selectActivityType(String type) { 
		wlib.selectByText(activityType,type);
	}
	
	public void setsubject(String name) {
		subject.sendKeys(name);;
	}

	public void setActivityStatus(String status) { 
		wlib.selectByText(activityStatus,status);
	}
	
	public void setDate()
	{
		date.sendKeys("18-02-2026 13:06");
	}
	
	public void getSaveButton() {
		saveButton.click();
	}
	

	public void SelectactivityType(String type) { 
		wlib.selectByText(activityType,type);
	}

}
