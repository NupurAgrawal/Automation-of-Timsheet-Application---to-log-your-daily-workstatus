package timesheetApp_LibraryUtilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//import org.apache.log4j.Logger;

	public class SystemProperties {
		
		public static String AppUrl, username, password ; 
		static Properties prop=new Properties();
		private static SystemProperties instance=new SystemProperties();
		// private static Logger Log=Logger.getLogger(SystemProperties.class.getName());
		 public  void GetProperties()
		{
		InputStream in = null;
			try {
				//InputStream in=getClass().getClassLoader().getResourceAsStream("//src_Main_Java_Resources//timesheetApp_Propertise//system.properties");
				in = new FileInputStream("C:\\Selenium\\workspace\\TimeSheetAutomation\\src_Main_Java_Resources\\timeSheetApp_Propertise\\system.properties");
				//prop=new Properties();
				prop.load(in);
			 	//System.out.println(prop.getProperty("AppUrl"));
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			AppUrl = prop.getProperty("AppUrl").toString();
			username = prop.getProperty("username").toString();
			password = prop.getProperty("password").toString();
		}
		 
		 public static SystemProperties getInstance(){
			  
			 return instance;
			 }
		
		 public static String get(String key)
		 {
			 String value = null;
			 try
			 {
			 value=prop.getProperty(key);
			 //System.out.println(prop.getProperty("AppUrl"));
			 }
			 
			 catch(Exception e)
			 {
				// Log.error("ERROR while geeting the value for property "+ key);
				 
			 }
			 
			return value;	
			
			 
		 }




}
