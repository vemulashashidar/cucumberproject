package stepDefinition;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.CheckoutPageObject;
import io.cucumber.java.en.Then;

import utils.testContextSetup;

public class CheckoutPageDefinition {
public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
public CheckoutPageObject checkoutPage;
testContextSetup tcs;
//Spring framework, EJB, 
//SRP
//
public CheckoutPageDefinition(testContextSetup tcs)
{
	this.tcs=tcs;
	this.checkoutPage = tcs.pom.getCheckoutPage();
}


@Then("verify user has ability to enter promo code and place the order")
public void  verify_user_has_ability_enter_promo()
{
	
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	
}

@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout(String name) throws InterruptedException
{
	
	checkoutPage.CheckoutItems();
	//Assertion to extract name from screen and compare with name
}


	
}

