package timesheetApp_testcases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

//import timesheetApp_LibraryUtilites.Constant;
import timesheetApp_LibraryUtilites.GlobalVariable;



public class ScreenShotOnFailure extends TestListenerAdapter{
	

	  @Override
	  
	  
		public void onTestFailure(ITestResult tr) {
			WebDriver driver = GlobalVariable.driver;
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
			String destDir = "target/surefire-reports/screenshots";
			new File(destDir).mkdirs();
			String destFile = dateFormat.format(new Date()) + ".png";
	 
	        try {
				FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        //String screenPath = "Saved <a href="+../reports/screenshots/" + destFile+">Screenshot</a>";
	        
	        String screenPath = "Saved <a href="+new File(destDir + "/" + destFile).getAbsolutePath()+">Screenshot</a>";
			Reporter.log(screenPath);
			//Reporter.se(false);
	     //   Reporter.log("<a href= screenshots/" + destFile + "><img src= screenshots/" + destFile + " style=width:100px;height:100px;/>" + destFile + "</a><br/>");
			//Reporter.log("Saved <a href=../screenshots/" + destFile + ">Screenshot</a>");
		}
	

	  
	  
}
