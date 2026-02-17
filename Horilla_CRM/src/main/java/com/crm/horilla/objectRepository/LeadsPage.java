package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class LeadsPage {
	
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public LeadsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Vinu_Company')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Edit']")
	private WebElement editLeadimg;
	
	@FindBy(xpath="//div[contains(text(),'Vinu_Company')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Change Owner']")
	private WebElement changeOwnerimg;
	
	@FindBy(xpath="//div[contains(text(),'Vinu_Company')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Convert']")
	private WebElement convertimg;
	
	@FindBy(xpath="//div[contains(text(),'Vinu_Company')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Duplicate']")
	private WebElement copyimg;
	
	@FindBy(xpath="//div[contains(text(),'Vinu_Company')]/../following-sibling::td[contains(@class,'sticky ')]//img[@alt='Delete']")
	private WebElement deleteimg;
	
	@FindBy(xpath="//a[contains(text(),'Single-Step Form')]")
	private WebElement singleStepForm;

	@FindBy(id="id_lead_owner")
	private WebElement leadOwner;
	
	@FindBy(id="id_first_name")
	private WebElement firstName;
	
	@FindBy(id="id_last_name")
	private WebElement lastName;
	
	@FindBy(id="id_title")
	private WebElement title;
	
	@FindBy(id="id_email")
	private WebElement email;
	
	@FindBy(id="id_lead_source")
	private WebElement leadSource;

	@FindBy(id="id_lead_status")
	private WebElement leadStatus;
	
	@FindBy(id="id_lead_company")
	private WebElement leadCompanyName;
	
	@FindBy(id="id_industry")
	private WebElement industry;
	
	@FindBy(id="id_country")
	private WebElement countryName;
	
	@FindBy(id="id_city")
	private WebElement city;
	
	@FindBy(id="id_annual_revenue")
	private WebElement annualRevenue;
	
	@FindBy(id="id_contact_number")
	private WebElement contactNumber;
	
	@FindBy(xpath="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	
	@FindBy(id="id_lead_owner")
	private WebElement changeOwnerTextField;
	
	@FindBy(id="//input[@name='account_action']/following-sibling::span[text()='Create New']")
	private WebElement createNewAccountRadioButton;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public void singleStepForm() {
		singleStepForm.click();
	}

	public void setLeadOwner(String leadOwnerName) {
		wlib.waitForElementToBeClikable(driver, leadOwner);
		wlib.selectByText(leadOwner,leadOwnerName);
	}

	public void setFirstName(String name) {
		wlib.waitForElementToBeClikable(driver, firstName);
		 firstName.sendKeys(name);;
	}

	public void setLastName(String lastNameValue) {
		wlib.waitForElementToBeClikable(driver, lastName);
		 lastName.sendKeys(lastNameValue);;
	}

	public void setTitle(String titleValue) {
		wlib.waitForElementToBeClikable(driver, title);
		title.sendKeys(titleValue);;
	}

	public void  setEmail(String emailValue) {
		wlib.waitForElementToBeClikable(driver, email);
		 email.sendKeys(emailValue);;
	}

	public void  setLeadSource(String source) {
		wlib.waitForElementToBeClikable(driver, leadSource);
		 wlib.selectByText(leadSource, source);
	}

	public void setLeadStatus(String status) {
		wlib.waitForElementToBeClikable(driver, leadStatus);
		wlib.selectByText(leadStatus, status);
	}

	public void setLeadCompanyName(String companyName) {
		wlib.waitForElementToBeClikable(driver, leadCompanyName);
		leadCompanyName.sendKeys(companyName);;
	}

	public void  setIndustry(String industryvalue) {
		wlib.waitForElementToBeClikable(driver, industry);
	 wlib.selectByText(industry, industryvalue);;   
	}

	public void setCountryName(String countryNameValue) {
		wlib.waitForElementToBeClikable(driver, countryName);
		wlib.selectByText(countryName, countryNameValue);
	}

	public void setCity(String cityValue) {
		wlib.waitForElementToBeClikable(driver, city);
		 city.sendKeys(cityValue);
	}

	public void setAnnualRevenue(String revenue) {
		wlib.waitForElementToBeClikable(driver, annualRevenue);
	    annualRevenue.sendKeys(revenue);;
	}

	public void setContactNumber(String number) {
		wlib.waitForElementToBeClikable(driver, contactNumber);
		contactNumber.sendKeys(number);;
	}
	
	public void getSaveButton() {
		saveButton.click();
	}
	
}
