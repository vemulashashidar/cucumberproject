package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;

public class TestBase {

	
	
	public WebDriver driver;
	 public File getDriverLocation() {
	        SeleniumManagerOutput.Result location = DriverFinder.getPath(ChromeDriverService.createDefaultService(), new ChromeOptions());
	        return new File(location.getDriverPath());
	    }
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties po=new Properties();
		po.load(fis);
		String url=po.getProperty("qurl");
		String browser1=po.getProperty("browser");
		System.out.print(browser1);
		
		
		if(driver==null) {
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver");
		//	if(po.getProperty("browser").equalsIgnoreCase("chrome")) {
			 ChromeOptions co = new ChromeOptions();
		       // options.setBrowserVersion("116.0.5845.111");
			//ChromeOptions co=new ChromeOptions();
			 
			
			 
			 ChromeDriverService service = new ChromeDriverService.Builder()
		                .usingDriverExecutable(getDriverLocation())
		                .build();
			driver=new ChromeDriver(service);	
			//}
			//if(po.getProperty("browser").equalsIgnoreCase("firefox")) {
			//driver=new FirefoxDriver();	
			//}
		
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			}
		
		return driver;
	}



}
