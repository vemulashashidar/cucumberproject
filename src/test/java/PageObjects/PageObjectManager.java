package PageObjects;

import org.openqa.selenium.WebDriver;

import stepDefinition.CheckoutPageDefinition;


public class PageObjectManager {

	public WebDriver driver;
	public LandingPageObjects lop;
	public OffersPageObjects opo;
	public CheckoutPageObject cpo;
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPageObjects landingpage() {
		lop=new LandingPageObjects(driver);
		return lop;
	}
	
	public OffersPageObjects OffersPage() {
		opo=new OffersPageObjects(driver);
		return opo;
	}
	
	public CheckoutPageObject getCheckoutPage()
	{
		cpo = new CheckoutPageObject(driver);
		return cpo;
	}
}
