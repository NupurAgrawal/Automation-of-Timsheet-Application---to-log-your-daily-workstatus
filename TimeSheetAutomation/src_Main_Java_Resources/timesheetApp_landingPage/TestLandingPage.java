package timesheetApp_landingPage;

import java.awt.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import timesheetApp_LibraryUtilites.CommonFuncs;
import timesheetApp_LibraryUtilites.SystemProperties;
import timesheetApp_testcases.BaseTestCase;
//import timesheetApp_LibraryUtilites.SeleniumProperties;

public class TestLandingPage extends BaseTestCase {
	
	// private static Logger Log= Logger.getLogger(TestLandingPage.class);
	 
	 /*@Test(priority=1)
	 public void testLandingPageElementsPresent()
	 {
		  test = extent
                  .startTest("Test case 1", "To Verify testLandingPage Elements are Present")  //Start test case
                  .assignAuthor("Shilpa Agrawal")   
                  .assignCategory("Functional"); 
		  test.log(LogStatus.INFO, "Started test: testLandingPageElementsPresent");   //Log info
		 if(CommonFuncs.verifyElementPresent("usernameTxtbox")&& CommonFuncs.verifyElementPresent("passwordTxtbox")
				 && CommonFuncs.verifyElementPresent("loginBtn"))
		 	{
			 test.log(LogStatus.PASS,"All required elements are Present");
			 Assert.assertTrue(true);
			 
		 	}
		 else
		 	{
			 test.log(LogStatus.FAIL, "User Name,Password and Login Button Elements not present");
			// Log.error("User Name,Password and Login Button Elements not present");
			Assert.fail("User Name,Password and Login Button Elements not present");
			extent.endTest(test); 
		 	}
	 }
	 
	 @Test(priority=2)
	 public void testLandingPageTitle() throws Exception
	 {
		 
		 test = extent
                 .startTest("Test case 2", "To verify the testLandingPage Title")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: testLandingPageTitle");
		 		 
		Assert.assertEquals(CommonFuncs.getPageTitle(), SystemProperties.get("loginPageTitle"));
		test.log(LogStatus.PASS, "LandingPageTitle Present");
		extent.endTest(test);
	 }
		*/
	 @Test(priority=3)
	 public void testValidLogin() throws Exception
	 {		 
		 test = extent
                 .startTest("Test case 3", "To verify the Valid Login")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 
		 test.log(LogStatus.INFO, "Started test: testValidLogin");
				
		 CommonFuncs.sendKeys("usernameTxtbox",SystemProperties.username);
		 CommonFuncs.sendKeys("passwordTxtbox",SystemProperties.password);
		 
		 CommonFuncs.click("loginBtn");
		 if(CommonFuncs.verifyElementPresent("addNewTaskButton"))
		 	{test.log(LogStatus.PASS, "Login Successful..");
			 Assert.assertTrue(true);
		 	}
		 else
			 {test.log(LogStatus.FAIL, "Login Failed..");
			 Assert.fail("Unable to find Elements on Login Page||ClassName:TestLogin||Method:testValidLogin");
			 }
		 extent.endTest(test); 
	 }	 
	 
	
	 @Test(priority=4)
	 public void testLoginPageElementsPresent() throws Exception
	 {
		 test = extent
                 .startTest("Test case 4", "To verify the Login page element present")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 
		 test.log(LogStatus.INFO, "Started test: testLoginPageElementsPresent");
		 if(CommonFuncs.verifyElementPresent("userNameTab"))
		 {			 
			 CommonFuncs.verifyElementPresent("manageCurrentTab");
			 CommonFuncs.verifyElementPresent("manageOlderTab");
			 CommonFuncs.verifyElementPresent("viewTotalHours");
			 CommonFuncs.verifyElementPresent("addNewTaskButton");
			// CommonFuncs.verifyElementPresent("downloadButton");
			 CommonFuncs.verifyElementPresent("selectActivityTypeDropdown");
			 CommonFuncs.verifyElementPresent("taskConatiner");
			 test.log(LogStatus.PASS, "All the Login page elements are Present");
			 Assert.assertTrue(true);
			 //CommonFuncs.verifyElementPresent("");
		 }
		 else 
		 {
			 Assert.fail("One of the elemment is not present ||ClassName:TestLogin||Method:testLoginPageElementsPresent");
		 	 test.log(LogStatus.FAIL, "All the Login page elements are not present");
		 } extent.endTest(test);
	 } 
	 
	 @Test(priority=5)
	 public void testUserGetsTaksDetailsPopupOnNewTaskAddition()  throws Exception
	 {
		 test = extent
                 .startTest("Test case 5", "To verify the User gets TaksDetailsPopup on click of NewAddTask button")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: testUserGetsTaksDetailsPopupOnNewTaskAddition");
		if(CommonFuncs.verifyElementPresent("addNewTaskButton"))
		{
			CommonFuncs.verifyElementVisibleThenClick("addNewTaskButton");
			if(CommonFuncs.verifyElementVisible("taskDetails"))
			{
		      test.log(LogStatus.PASS, "Task Details Popup Displyed");
		      Assert.assertTrue(true);
		      if(CommonFuncs.verifyElementVisible("cancelButton"))
		      {
		     	  CommonFuncs.click("cancelButton");
		          test.log(LogStatus.INFO, "Task Details Popup closed");
		      }
		      else
		      test.log(LogStatus.INFO, "Task Details Popup cancel button not displayed");
		    }
			else 
		      {
		    	  test.log(LogStatus.FAIL, "Task Details Popup not displyed");
				  Assert.fail("task detailspop-up not diaplyed ||ClassName:TestLogin||Method:testUserGetsTaksDetailsPopupOnNewTaskAddition");
		      }
		}else
			test.log(LogStatus.INFO, "Add new task button not visible");
		extent.endTest(test);
	}
	 
	 
	 @Test(priority=6)
	 public void testValidEntryadded() throws Exception
	 {
		 test = extent
                 .startTest("Test case 6", "To verify the testValidEntryadded")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: testValidEntryadded");
		// Dimension size = CommonFuncs.findElement("totalRowCount").getSize();
		 //System.out.println("**********"+size);
		// String totalNoOfRows = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
		 //test.log(LogStatus.INFO, "No of entires present as : "+totalNoOfRows);
		
		 CommonFuncs.verifyElementVisible("addNewTaskButton");
		 CommonFuncs.click("addNewTaskButton");
			
		  
		 if(CommonFuncs.verifyElementVisible("taskDetails"))
				test.log(LogStatus.INFO, "Add task details popup displayed");
			{
				CommonFuncs.verifyElementVisible("dateTab");
				CommonFuncs.verifyElementVisible("hoursTab");
				
				//String day = CommonFuncs.findElement("hoursTab").getText();
				String day = CommonFuncs.findElement("dateTab").getText().split("\n")[0].split(" ")[0];
				if(day=="Saturday" || day=="Sunday")
				
				
				//CommonFuncs.verifyElementPresent("projectTabTextBox");
				/*test.log(LogStatus.INFO, "Date tab, Hours tab visible");
				//String projectdata = CommonFuncs.findElement("projectTabTextBox").getText();
				String projectdata = CommonFuncs.getText("projectTabTextBox");
				if(projectdata=="WEEKEND" || projectdata=="HOLIDAY")*/
				{
					test.log(LogStatus.PASS, "task details cannot be added as its :"+day);
					CommonFuncs.verifyElementVisibleThenClick("submitButton");
					
					
					String totalNoOfRows = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
					 //test.log(LogStatus.INFO, "No of entires present as : "+totalNoOfRows);
					
					 String increaseCount = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
					if(totalNoOfRows!=increaseCount)
					{
						test.log(LogStatus.PASS, "Weekend/holiday entry added, no of row as : "+increaseCount);
					Assert.assertTrue(true);
					}
						
					else
						test.log(LogStatus.FAIL, "Weekend/holiday entry not added, no of row as : "+increaseCount);
					Assert.fail("Weekend/Holiday entries not added||Name:TestLogin||Method:testValidEntryadded");
				}
				else
				{
				CommonFuncs.sendKeys("projectTabTextBox", "ProjectDatafortesting");
				test.log(LogStatus.PASS, "Project task details added as :ProjectDatafortesting");
				CommonFuncs.verifyElementVisible("internalTabTextBox");
				CommonFuncs.sendKeys("internalTabTextBox", "InternalData");
				test.log(LogStatus.PASS, "Project task details added as :internalData");				
				CommonFuncs.verifyElementVisibleThenClick("submitButton");
				String increaseCountOnWeekDays = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
				String totalNoOfRows = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
				 //test.log(LogStatus.INFO, "No of entires present as : "+totalNoOfRows);
				
				if(totalNoOfRows!=increaseCountOnWeekDays)
				{				
					test.log(LogStatus.PASS, "Working day entry added, no of row as : "+increaseCountOnWeekDays);
					Assert.assertTrue(true);
				}
				else
					test.log(LogStatus.FAIL, "Working day entry not added, no of row as : "+increaseCountOnWeekDays);
				Assert.fail("Working day entries not diaplyed||Name:TestLogin||Method:testValidEntryadded");
				}
				
			} 
		}
	
	 @Test(priority=7)
	 public void testAllEntriesDisplayed() throws Exception
	 {
		 test = extent
                 .startTest("Test case 7", "To verify the testAllEntriesDisplayed")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: testAllEntriesDisplayed");
		 CommonFuncs.verifyElementVisible("taskDataTable"); 
		 
				Select dropdown= new Select(CommonFuncs.findElement("taskDataTable"));
				//dropdown.selectByVisibleText("All");
				dropdown.selectByIndex(2);
				//dropdown.selectByValue("option2");
				
				String rowsDisplayed = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[3];
				String totalNoOfRows = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
				
				if(rowsDisplayed.toString()==totalNoOfRows.toString())
				{
					
					test.log(LogStatus.PASS, "All entired displayed on selection of 'All' option as "+totalNoOfRows);
					test.log(LogStatus.INFO, "Total no of rows displayed as : "+rowsDisplayed);
					test.log(LogStatus.INFO, "Total no of rows present are as : "+totalNoOfRows);
					Assert.assertTrue(true);
				}
				else
					test.log(LogStatus.FAIL, "All entired not displayed on selection of 'All' option");
				test.log(LogStatus.INFO, "Total no of rows displayed as : "+rowsDisplayed);
				test.log(LogStatus.INFO, "Total no of rows present are as : "+totalNoOfRows);
				Assert.fail("All entries not diaplyed||Name:TestLogin||Method:testAllEntriesDisplayed");
	 }
	 	 
	 
	 @Test(priority=8)
	 public void test5EntriesDisplayed() throws Exception
	 {
		 test = extent
                 .startTest("Test case 8", "To verify the test5EntriesDisplayed")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: test5EntriesDisplayed");
		 CommonFuncs.verifyElementVisible("taskDataTable"); 
		 
				Select dropdown= new Select(CommonFuncs.findElement("taskDataTable"));
				dropdown.selectByVisibleText("5");
				//dropdown.selectByIndex(2)
				//dropdown.selectByValue("option2");
				
				String rowsDisplayed = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[3];
				String totalNoOfRows = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
				
				if(rowsDisplayed.toString()=="5")
				{
					test.log(LogStatus.PASS, "5 entires displayed on selection of '5' option from dropdown");
					test.log(LogStatus.INFO, "Total no of rows displayed as : "+rowsDisplayed);
					test.log(LogStatus.INFO, "Total no of rows present are as : "+totalNoOfRows);
					Assert.assertTrue(true);
				}
				else
					test.log(LogStatus.FAIL, "5 entires not displayed on selection of '5' option from dropdown");
				Assert.fail("5 entries not diaplyed||Name:TestLogin||Method:test5EntriesDisplayed");
	 }
	 	
	 @Test(priority=9)
	 public void test7EntriesDisplayed() throws Exception
	 {
		 test = extent
                 .startTest("Test case 9", "To verify the test7EntriesDisplayed")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: test7EntriesDisplayed");
		 CommonFuncs.verifyElementVisible("taskDataTable"); 
		 
				Select dropdown= new Select(CommonFuncs.findElement("taskDataTable"));
				dropdown.selectByVisibleText("5");
				//dropdown.selectByIndex(2)
				//dropdown.selectByValue("option2");
				
				String rowsDisplayed = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[3];
				String totalNoOfRows = CommonFuncs.findElement("numberOfRowsTabledetails").getText().split("\n")[0].split(" ")[5];
				
				if(rowsDisplayed.toString()=="7")
				{
					test.log(LogStatus.PASS, "7 entires displayed on selection of '7' option from dropdown");
					test.log(LogStatus.INFO, "Total no of rows displayed as : "+rowsDisplayed);
					test.log(LogStatus.INFO, "Total no of rows present are as : "+totalNoOfRows);
					Assert.assertTrue(true);
				}
				else
					test.log(LogStatus.FAIL, "7 entires not displayed on selection of '7' option from dropdown");
				Assert.fail("7 entries not diaplyed||Name:TestLogin||Method:test7EntriesDisplayed");
	 }
	 
	 
	 
	 
  @Test(priority=10)
	 public void testValidLogout() throws Exception
	 {
		 test = extent
                 .startTest("Test case 10", "To verify the testValidLogout")  //Start test case
                 .assignAuthor("Shilpa Agrawal")   
                 .assignCategory("Functional");
		 test.log(LogStatus.INFO, "Started test: testValidLogout");
		 
		 if(CommonFuncs.verifyElementVisible("userNameTab"))
		  {
			test.log(LogStatus.INFO, "In Login state");
			Assert.assertTrue(true);
			CommonFuncs.click("userNameTab");
			CommonFuncs.click("signOutBtn");
			 Assert.assertEquals(CommonFuncs.getPageTitle(), SystemProperties.get("loginPageTitle"));
			 test.log(LogStatus.PASS, "Logout Successfully..");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.fail("Unable to logout ||ClassName:TestLogin||Method:testValidLogout");
			 test.log(LogStatus.FAIL, "Logout failed");
		 }extent.endTest(test);
	 } 
}
