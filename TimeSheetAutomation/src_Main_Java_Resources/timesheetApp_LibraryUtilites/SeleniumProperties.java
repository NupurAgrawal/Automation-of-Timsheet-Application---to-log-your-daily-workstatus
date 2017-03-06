package timesheetApp_LibraryUtilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import org.apache.log4j.Logger;


public class SeleniumProperties {
	
		static Properties prop=new Properties();
		 private static SeleniumProperties instance=new SeleniumProperties();
		// private static Logger Log=Logger.getLogger(SeleniumProperties.class.getName());	
		 public void  getSeleniumProperties()
		{
			 InputStream in = null;
			try {
				in = new FileInputStream("C:\\Selenium\\workspace\\TimeSheetAutomation\\src_Main_Java_Resources\\timeSheetApp_Propertise\\selenium.properties");
				prop.load(in);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		 
 public static SeleniumProperties getInstance(){
			   
			 return instance;
			 }
		 	 
		 public static String get(String key)
		 {
			 //System.out.println("*IN GET FUNCTION***KEY="+key+"*****selenimum prop******");
			 String value=null;
			// System.out.println(prop.toString());
			 value=prop.getProperty(key);
			 //System.out.println("----IN GET FUNCTION---prop value="+value);
			 //System.out.println(prop.getProperty("AppUrl")); 
			return value;	
			
			 
		 }


	}

