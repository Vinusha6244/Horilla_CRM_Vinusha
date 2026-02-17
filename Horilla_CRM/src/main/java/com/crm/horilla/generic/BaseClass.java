package com.crm.horilla.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.crm.horilla.fileutility.ExcelUtility;
import com.crm.horilla.fileutility.FileUtility;
import com.crm.horilla.objectRepository.HorillaHomePage;
import com.crm.horilla.objectRepository.HorillaLoginPage;
import com.crm.horilla.webDriverUtility.JavaUtility;
import com.crm.horilla.webDriverUtility.UtilityClassObject;
import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class BaseClass {
    public  WebDriver  driver=null;
    public static  WebDriver  sdriver=null;
	public  FileUtility fileutility=new FileUtility();
	public  ExcelUtility excel=new ExcelUtility();
	public  WebDriverUtility webDriverUtility=new WebDriverUtility();
	public  JavaUtility javaUtility=new JavaUtility();
	
	
	@BeforeSuite(groups= {"SmokeTesting","RegressionTesting"})
      public void connectToDB() throws Throwable
      {
      }
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	 public void openBrowser(String browser) throws Throwable
	//public void openBrowser() throws Throwable
	  {
		//String browser=fileutility.getDataFromPropertyFile("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equals("fireFox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}else 
		{
			driver=new ChromeDriver();
		}
		sdriver=driver;
		//UtilityClassObject.setDriver(driver);
	  }
	HorillaLoginPage lp=new HorillaLoginPage(driver);
	@BeforeMethod(alwaysRun=true)
	  public void login() throws Throwable
	  {
		//webDriverUtility.waitForPageToLoad(driver);
		String url=fileutility.getDataFromPropertyFile("url");
		String userName=fileutility.getDataFromPropertyFile("username");
		String passWord=fileutility.getDataFromPropertyFile("password");  
		driver.get(url);
		driver.manage().window().maximize();
		
		HorillaLoginPage lp=new HorillaLoginPage(driver);
		lp.loginToApp(userName, passWord);
		String confirmationMSG=driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText();
	    Assert.assertEquals(confirmationMSG, "Login successful.");
	    //UtilityClassObject.getTest().log(Status.PASS, "Login successful. and confirmation message displayed Succecfully");
	  }
	@AfterMethod(alwaysRun=true)
	  public void logOut() throws Throwable
	  {
		HorillaHomePage homePage=new HorillaHomePage(driver);
		homePage.logOutLink();
	  }
	@AfterClass(alwaysRun=true)
	  public void closeBrowser() throws Throwable
	  {    Thread.sleep(2000);
		  driver.quit();
	  }
	@AfterSuite(alwaysRun=true)
	  public void closeDBConnection() throws Throwable
	  {
		
	  }

}