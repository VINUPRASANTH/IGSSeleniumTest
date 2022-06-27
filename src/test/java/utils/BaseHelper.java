package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseHelper {
	
	public static WebDriver driver;
	protected Properties config;
	
	public abstract void initializeObjest();
	public void init() throws Exception{
		loadInputs();
		browserInitialize();
		initializeObjest();
	}
	
	public void loadInputs() throws FileNotFoundException, IOException{
		config = new Properties();
		config.load(new FileInputStream("src/test/resources/testdata/config.properties"));
		
	}
	public void browserInitialize() {
		String projectPath = System.getProperty("user.dir");
			if(config.getProperty("platform").equals("windows")){
		           System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/webdriver/chromedriver.exe");
		          
		     }else {
		    	 System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/webdriver/chromedriver");
		     }
			 driver = new ChromeDriver();
		
	}
	public Properties getConfig() {
		return config;
	}
		

}
