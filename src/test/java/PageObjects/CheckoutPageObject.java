package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObject {
	public WebDriver driver;

	public CheckoutPageObject(WebDriver driver)
	{
		this.driver = driver;
		
	}
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.xpath("//button[contains(text(),'Apply')]");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

	
	
	
	public void CheckoutItems() throws InterruptedException
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
		Thread.sleep(2000);
	}
	
	public Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	
	
	
}
