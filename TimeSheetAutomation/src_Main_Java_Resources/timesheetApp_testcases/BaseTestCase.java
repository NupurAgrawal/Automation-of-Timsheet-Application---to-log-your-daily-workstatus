package timesheetApp_testcases;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import timesheetApp_LibraryUtilites.Constant;
import timesheetApp_LibraryUtilites.GlobalVariable;
//import timesheetApp_LibraryUtilites.Log;
import timesheetApp_LibraryUtilites.SystemProperties;
import timesheetApp_LibraryUtilites.SeleniumProperties;
import timesheetApp_testcases.BaseTestCase;


 @Listeners(timesheetApp_testcases.ScreenShotOnFailure.class)
 public class BaseTestCase {
	 public ExtentReports extent;
	 public ExtentTest test;
  //WebDriver driver;
  //ReadProp.getInstance().getProperties();
   @BeforeSuite(alwaysRun = true)
  public void BeforeSuite()
  {
	   extent = new ExtentReports("C:\\Selenium\\workspace\\TimeSheetAutomation\\Reporting\\TestAutomationReport.html", true); 
	   extent.addSystemInfo("Product Version", "3.0.0")   //System or environment info
       .addSystemInfo("Author", "Shilpa Agrawal");
	   
     SystemProperties.getInstance().GetProperties();
     //System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
     System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
     SeleniumProperties selProp=new SeleniumProperties();
	 selProp.getSeleniumProperties();   
  	 GlobalVariable.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 GlobalVariable.driver.manage().window().maximize();
	 GlobalVariable.driver.get(SystemProperties.AppUrl);
  	 Constant.Username=SystemProperties.username;
	 Constant.Password=SystemProperties.password;
     
   }
   
   @AfterClass
   public void AfterClass()
   {
    GlobalVariable.driver.quit();
    extent.flush();
   }
   
  /* @AfterSuite(alwaysRun = true)
   public void AfterSuite()
   {
    System.out.println("After Suite");
    }*/
   }