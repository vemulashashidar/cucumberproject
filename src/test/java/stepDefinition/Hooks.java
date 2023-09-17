package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.testContextSetup;

public class Hooks {
	
	testContextSetup tcs;
	
	public Hooks(testContextSetup tcs) {
		this.tcs=tcs;
	}

	@After
	public void AfterScenario() throws IOException {
		
		tcs.TB.WebDriverManager().quit();
	}
	
	@AfterStep
	public void TakeScreenshot(Scenario scenario) throws IOException {
		
		WebDriver driver=tcs.TB.WebDriverManager();
		
		if(scenario.isFailed()) {
			
		File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		byte[] filecontent=FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(filecontent, "image/png", "image");
		}
	}
}
