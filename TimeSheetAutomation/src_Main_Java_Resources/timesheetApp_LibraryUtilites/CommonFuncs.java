package timesheetApp_LibraryUtilites;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import timesheetApp_testcases.BaseTestCase;

public class CommonFuncs 
{
	private static Logger Log = Logger.getLogger(CommonFuncs.class.getName());
	
public boolean Login()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    BaseTestCase test = new BaseTestCase(); 	
    test.BeforeSuite();
		
//	SystemProperties p=new SystemProperties();
	//SeleniumProperties sel=new SeleniumProperties();
    
	
	
	Log.info("Started Execution Of Test Suite..");
    System.out.println("User able to login successfully");
	
	return true;

	}

public boolean logout()
	{
	GlobalVariable.driver.manage().window().maximize();
	if(GlobalVariable.driver.findElement(By.className("dropdown-toggle")).isDisplayed() == true)
		{
		GlobalVariable.driver.findElement(By.className("dropdown-toggle")).click();
		GlobalVariable.driver.findElement(By.className("dropdown-menu")).click();
		System.out.println("User able to logout successfully");
		}
	return true;
	}



public static WebElement findElement(String key) throws Exception
	{

		WebElement element = null;
		try
		{
			
			String locatorDetails[]=SeleniumProperties.get(key).split(":",2);
			String locatorType=locatorDetails[0];
			String locatorVal=locatorDetails[1];
			if(locatorType.equalsIgnoreCase("id"))
				element= GlobalVariable.driver.findElement(By.id(locatorVal));
		 
			if(locatorType.equalsIgnoreCase("name"))
				element= GlobalVariable.driver.findElement(By.name(locatorVal));
		
			if(locatorType.equalsIgnoreCase("xpath"))
				element= GlobalVariable.driver.findElement(By.xpath(locatorVal));
		
			if(locatorType.equalsIgnoreCase("css"))
				element= GlobalVariable.driver.findElement(By.cssSelector(locatorVal));
			
			if(locatorType.equalsIgnoreCase("class"))
				element= GlobalVariable.driver.findElement(By.className(locatorVal));
		}
		catch(Exception e)
		{
			//Log.error("Element not found exception for:- "+ key);
			throw(e);
		}
		return element;
	}

//*********** Click Element on Page, takes 'key' parameter */
public static void click(String key) throws Exception
	{
		WebElement element=CommonFuncs.findElement(key);
		//System.out.println("######################User TAB ################# :"+element.getText());
		//System.out.println("***************************Element Size : "+element.getSize());
		if(element!=null)
			element.click();		
			else
		{
			//Log.error("Unable to find element with Key: "+key);
			throw new ElementNotFoundException(key, SeleniumProperties.get(key).split(":",2)[0], SeleniumProperties.get(key).split(":",2)[1]);
		}
	}

//************ Purpose: Type text in Element on Page, takes 'key' and 'text' 
 
public static void sendKeys(String key,String text) throws Exception
	{
	//System.out.println("***********   ELEMENT ********"+text);
		WebElement element=CommonFuncs.findElement(key);
		
		if(element!=null)
		{
			element.clear();
			element.sendKeys(text);
			//System.out.println(element.sendKeys(text));
		}
		else
		{
			Log.error("Unable to find element with Key: "+key);
			throw new ElementNotFoundException(key, SeleniumProperties.get(key).split(":",2)[0], SeleniumProperties.get(key).split(":",2)[1]);
		}	
	}

//************ Purpose: Verify if element exists on Page, takes 'key' 
 public static Boolean verifyElementPresent(String key)
	{
	try
		{
		WebElement element=CommonFuncs.findElement(key);
		if(element!=null)
			return true;
		else
			{
			Log.error("Unable to find element having key: "+ key);	
			return false;
			}
		}
	catch(Exception e)
		{
		Log.error("Element not found:-"+ key);
		return false;
		}

	}
	
//*********** Purpose: Verify if element exists on Page, takes 'key' 
 public static Boolean verifyElementVisible(String key) 
	{
	try
		{
		WebElement element=CommonFuncs.findElement(key);
		if(element!=null)
			return true;
		else
			{
			Log.error("Unable to find element having key: "+ key);	
			return false;
			}
		}
	catch (Exception e)	
		{
		Log.error("Element not found:-"+ key);
		return false;
		}
	}

//*********** Purpose: Wait for element exists **/

public static boolean waitForElementClickable(String key,int i)
	{
     @SuppressWarnings("unused")
	WebElement element = null;
     WebDriverWait wait=new WebDriverWait(Constant.driver,i);
	try
		{
		//System.out.println(SeleniumProperties.get(key));
		String locatorDetails[]=SeleniumProperties.get(key).split(":",2);
		String locatorType=locatorDetails[0];
		String locatorVal=locatorDetails[1];
		if(locatorType.equalsIgnoreCase("id"))
			element=wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorVal)));
		if(locatorType.equalsIgnoreCase("name"))
			element=wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorVal)));
		if(locatorType.equalsIgnoreCase("xpath"))
			element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorVal)));
		if(locatorType.equalsIgnoreCase("css"))
			element=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorVal)));
		if(locatorType.equalsIgnoreCase("class"))
			element=wait.until(ExpectedConditions.elementToBeClickable(By.className(locatorVal)));
		}
	catch(Exception e)
		{
		Log.error("Element not visible exception for:- "+ key);
		return false;
		}
	return true;
	}

//
public static WebElement getSize(String key) throws Exception
{

	WebElement element = null;
	try
	{
	 element=CommonFuncs.findElement(key);
	//System.out.println("######################User TAB ################# :"+element.getText());
	//System.out.println("***************************Element Size : "+element.getSize());
	 	if(element!=null)
		element.getSize();		
		else
		{
		//Log.error("Unable to find element with Key: "+key);
		throw new ElementNotFoundException(key, SeleniumProperties.get(key).split(":",2)[0], SeleniumProperties.get(key).split(":",2)[1]);
		}
	}
	catch(Exception e)
		{
		//Log.error("Element not found exception for:- "+ key);
		throw(e);
		}
	return element;
}


//*********** Purpose: Return Page Title  **/
public static String getPageTitle() throws Exception
	{
	String title = null;
	try
		{
		title=GlobalVariable.driver.getTitle();
		}
	catch(Exception e)
		{
		Log.error("Error while getting page tilte");
		throw(e);
		}
	return title;
	}

/* Purpose: Verify if element exists on Page, takes 'key'  **/
public static Boolean verifyElementAtrribute(String key, String attribute, String value) {
	try
		{
		WebElement element;
		if(attribute.equalsIgnoreCase("background-color"))
			{
			element=CommonFuncs.findElement(key);
			Boolean status=CommonFuncs.waitForElementClickable(key, 10);
			if(element!=null && status)
				{
				Thread.sleep(2000);
				String text =element.getCssValue(attribute).toString();
				String[] numbers = text.replace("rgba(", "").replace(")", "").split(",");
				int number1=Integer.parseInt(numbers[0]);
				numbers[1] = numbers[1].trim();
				int number2=Integer.parseInt(numbers[1]);
				numbers[2] = numbers[2].trim();
				int number3=Integer.parseInt(numbers[2]);
				String hex = String.format("#%02x%02x%02x", number1,number2,number3);
					if(value.equalsIgnoreCase(hex))
						return true;
					else
						{
						Log.error("Expected: "+value+" Actual: "+hex );
						return false;
						}
				}
			else
				{
				Log.error("Unable to find element having key: "+ key);
				return false;
				}
			}
		else if(attribute.equalsIgnoreCase("text"))
			{
			element=CommonFuncs.findElement(key);
			if(element!=null)
				{
				//  String txt= (String) ((JavascriptExecutor) Constant.driver).executeScript( "return jQuery(arguments[0]).text();", element);
				//((JavascriptExecutor)Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
				if(value.equals(element.getAttribute("innerText"))||value.equals(element.getText())||value.equals(element.getAttribute("title"))
					||value.equals((String) ((JavascriptExecutor) Constant.driver).executeScript(
		            "return jQuery(arguments[0]).text();", element)))
					return true;
				else
					{
					Log.error("Expected: "+value+" Actual: "+element.getText()+element.getAttribute("innerText")+value.equals(element.getAttribute("title"))+(String) ((JavascriptExecutor) Constant.driver).executeScript("return jQuery(arguments[0]).text();", element) );
					return false;
					}
			
				}
			else
				{
				Log.error("Unable to find element having key: "+ key);
				return false;
				}
				
			}
		
		else
			{
			Log.error(key +" is invalid ||Class Name:CommonFuns||Method Name:verifyElementAtrribute");
			return false;
			}
		}
	catch(Exception e)
	{
	Log.error("Element not found:-"+ key);
		return false;
	}	
			
}


//*********** Purpose: Verify if element exists on Page, takes 'key'  and click on it
public static void verifyElementVisibleThenClick(String key) throws Exception
	{
	try
		{
		WebElement element=CommonFuncs.findElement(key);
		if(element!=null)
			element.click();		
				else
			{
				//Log.error("Unable to find element with Key: "+key);
				throw new ElementNotFoundException(key, SeleniumProperties.get(key).split(":",2)[0], SeleniumProperties.get(key).split(":",2)[1]);
			}
		
		}
	catch (Exception e)	
		{
		Log.error("Element not found:-"+ key);
		}
	}

//*********** Purpose: Return Page Title  **/
public static String getText(String key) 
	{
	String value = null;
	WebElement element = null;
	try
	{
	element=CommonFuncs.findElement(key);
	 	if(element!=null){
	 		//System.out.print(value);
	 		value=element.getAttribute("value");
	System.out.print(value);
	 	if (value=="WEEKEND")
	 	{
	 		System.out.println("WEEKEND");
	 		
	 	}
	 	else if (value=="HOLIDAY")
	 	{
	 		System.out.println("HOLIDAY");
	 	}
		}
		
		//Log.error("Unable to find element with Key: "+key);
		//throw new ElementNotFoundException(key, SeleniumProperties.get(key).split(":",2)[0], SeleniumProperties.get(key).split(":",2)[1]);
		
	}
	catch(Exception e)
		{
		//Log.error("Element not found exception for:- "+ key);
		e.printStackTrace();
		}
	return value;
	}
	

}