package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;
import stepDefinition.TestCases;

public class testContextSetup {

	public String productinhomepage;
	public WebDriver driver;
	public PageObjectManager pom;
	public GenericUtils GU;
	public TestBase TB;
	
	public testContextSetup() throws IOException {
		TB=new TestBase();
		pom=new PageObjectManager(TB.WebDriverManager());
		GU=new GenericUtils(TB.WebDriverManager());
	}

}
