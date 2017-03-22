//test
package timesheetApp_landingPage;

class MainClass
{
	
	public void LoginTestCases() throws Exception
	{
	TestLandingPage testLanding = new TestLandingPage();
	testLanding.testLandingPageElementsPresent();
	testLanding.testLandingPageTitle();
	testLanding.testValidLogin();
	testLanding.testLoginPageElementsPresent();
	testLanding.testUserGetsTaksDetailsPopupOnNewTaskAddition();
	testLanding.testValidEntryadded();
	testLanding.testAllEntriesDisplayed();
	testLanding.test5EntriesDisplayed();
	testLanding.test7EntriesDisplayed();
	testLanding.testValidLogout();
	
	}



}