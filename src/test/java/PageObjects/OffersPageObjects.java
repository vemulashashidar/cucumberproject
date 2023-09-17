package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageObjects {

	public WebDriver driver;
	public OffersPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public By findingthefirstelement=By.cssSelector("tr td:nth-child(1)");
	public By SearchBoxTopDeals=By.xpath("//input[@id='search-field']");
	
public String getProductTextinOffers() {
		
		return driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}
	public void searchTopDealButton(String name) {
		
		driver.findElement(SearchBoxTopDeals).sendKeys(name);
	}
}
