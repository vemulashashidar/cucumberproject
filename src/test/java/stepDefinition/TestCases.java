package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPageObjects;
import PageObjects.OffersPageObjects;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.testContextSetup;

public class TestCases {
	

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	testContextSetup test;
	LandingPageObjects landingPage;
	public PageObjectManager pom;
	//Spring framework, EJB, 
	//SRP
	//
	public TestCases(testContextSetup test)
	{
		this.test=test;
	}
	
		@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
			landingPage=test.pom.landingpage();
			Assert.assertTrue(landingPage.getTitleLanding().contains("GreenKart"));
			//test.driver=new ChromeDriver();	
		//	test.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
	}

		@When("^user searched with Shortname (.+) and extracted actual name of product$")
		public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName ) throws InterruptedException {
			landingPage=test.pom.landingpage();
			landingPage.searchItem(shortName);
			Thread.sleep(4000);
			test.productinhomepage = landingPage.getProductText().split("-")[0].trim();
			System.out.println(landingPageProductName +" is extracted from Home page");
				
	}

		@When("Added {string} items of the selected product to cart")
		public void Added_items_product(String quantity)
		{
			landingPage=test.pom.landingpage();
			landingPage.incrementQuantity(Integer.parseInt(quantity));
			landingPage.addToCart();
			
		}
		

	
}
