package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import PageObjects.LandingPageObjects;

public class GenericUtils {

	public WebDriver driver;
	public testContextSetup tcs;
	public LandingPageObjects lpo;
	
	public GenericUtils(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public void SwitchingWindow() {
		
	    Set s1=driver.getWindowHandles();
	    Iterator<String> I1=s1.iterator();
	    String parentwindow=I1.next();
	    String childwindow=I1.next();	    
	    driver.switchTo().window(childwindow);
	}
}
