package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class ShedulePage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public ShedulePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="horilla_calendar")
	private WebElement calendarLink;
	
	@FindBy(id="activity")
	private WebElement activityLink;

	public void calendarLink() {
		wlib.waitForElementToBeClikable(driver, calendarLink);
		calendarLink.click();
	}
	
	public void activityLink() {
		wlib.waitForElementToBeClikable(driver, activityLink);
		activityLink.click();
	}
	

}
