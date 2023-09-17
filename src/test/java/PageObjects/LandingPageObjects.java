package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {
	
	public WebDriver driver;
	public LandingPageObjects(WebDriver driver) {
		this.driver=driver;
	}


	public By searchbox= By.cssSelector("input.search-keyword");

	public String url="https://rahulshettyacademy.com/seleniumPractise/#/";
	public By searchbutton= By.cssSelector("button.search-button");
	public By TopDealsButton=By.xpath("//div/a[contains(text(),'Top Deals')]");
	
	By increment=   By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");
	
	public String getProductText() {
		
		return driver.findElement(By.cssSelector("h4.product-name")).getText();
	}
	
	public void searchItem(String name)
	{
		driver.findElement(searchbox).sendKeys(name);
	}
	
	public String getTitleLanding() {
		return driver.getTitle();
	}
	
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(TopDealsButton).click();
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
}
