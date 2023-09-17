package stepDefinition;

import org.testng.Assert;

import PageObjects.LandingPageObjects;
import PageObjects.OffersPageObjects;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.Then;
import utils.GenericUtils;
import utils.testContextSetup;

public class OffersPage {
	
	public testContextSetup tcs;
	public String productinlanding;
	public GenericUtils generic;
	public OffersPage(testContextSetup tcs) {
		this.tcs=tcs;
	}
	public PageObjectManager pom;
	public LandingPageObjects LandingPage;
	public OffersPageObjects OffersPage;
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    //offer pafe->enter_>grab text

		switchToOffersPage();
		LandingPage=tcs.pom.landingpage();
		OffersPage=tcs.pom.OffersPage();
		OffersPage.searchTopDealButton(shortName);
		Thread.sleep(2000);
		 productinlanding = OffersPage.getProductTextinOffers();
		
			
	}

	public void switchToOffersPage()
	{
		//if switched to offer page-> skip below part
		LandingPage=tcs.pom.landingpage();
		
		LandingPage.selectTopDealsPage();
		generic=tcs.GU;
		generic.SwitchingWindow();
		//explicit wait, parse string
		
	}
	

	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page()
	{
		Assert.assertEquals(tcs.productinhomepage, productinlanding);
		
	}
}
