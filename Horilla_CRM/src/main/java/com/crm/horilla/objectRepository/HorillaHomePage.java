package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class HorillaHomePage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public HorillaHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome')]")
	private WebElement homeDashBoard;
	
	@FindAll({@FindBy(xpath="//img[@alt='Sales']"),@FindBy(id="sales"),@FindBy(xpath="//*[@id='sales']")})
	private WebElement salesLink;
	
	@FindBy(id="analytics")
	private WebElement analyticsLink;
	
	@FindBy(id="schedule")
	private WebElement scheduleLink;
	
	@FindBy(id="people")
	private WebElement peopleLink;
	
	@FindBy(xpath="//img[@alt='Adam']")
	private WebElement profileLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logOutLink;
	
	@FindBy(xpath="//button[@id='darkModeToggle']/following-sibling::button")
	private WebElement settingsIcon;
	
	@FindBy(xpath="//span[text()='All Company']/ancestor::div[@class='relative dropdown-wrapper']")
	private WebElement allComapnyIcon;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}

	public WebElement getHomeLink() {
		wlib.waitForElementToBeClikable(driver, homeLink);
		return homeLink;
	}
	
	public WebElement getHomeDashBoard() {
		wlib.waitForElementToBeClikable(driver, homeDashBoard);
		return homeDashBoard;
	}
	
	public  void clicksalesLink()  {
		wlib.waitForElementToBeClikable(driver, salesLink);
		 salesLink.click();
	}


	public WebElement getAnalyticsLink() {
		wlib.waitForElementToBeClikable(driver, analyticsLink);
		return analyticsLink;
	}


	public WebElement getScheduleLink() {
		wlib.waitForElementToBeClikable(driver, scheduleLink);
		return scheduleLink;
	}


	public WebElement getPeopleLink() {
		wlib.waitForElementToBeClikable(driver, peopleLink);
		return peopleLink;
	}


	public WebElement getProfileLink() {
		wlib.waitForElementToBeClikable(driver, profileLink);
		return profileLink;
	}


	public WebElement getSettingsIcon() {
		wlib.waitForElementToBeClikable(driver, settingsIcon);
		return settingsIcon;
	}


	public WebElement getAllComapnyIcon() {
		wlib.waitForElementToBeClikable(driver, allComapnyIcon);
		return allComapnyIcon;
	}
	

	public void logOutLink() throws Throwable {
		wlib.waitForElementToBeClikable(driver, profileLink);
		wlib.waitForElementPresent(driver, profileLink);
		Thread.sleep(5000);
		profileLink.click();
		logOutLink.click();
	}



}
