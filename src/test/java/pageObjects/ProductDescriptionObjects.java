package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.Interact;

public class ProductDescriptionObjects extends Interact{

	
	Scenario scn;
	 
	private By product_Header_Element = By.xpath("//span[@id='productTitle']");
	private By price_range_of_product = By.xpath("//span[@class='a-price-whole']");
	public ProductDescriptionObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void ValidateProducDescriptionHeader(String expected) {
		String actual = getText(product_Header_Element);
		scn.write("actual:"+ actual +", Expected:" +expected);
		Assert.assertEquals("Product Header", expected.trim(), actual.trim());
	}
	
	public void ValidatePriceRange() {
		List<WebElement> actual = getListOfWebElements(price_range_of_product);
		int tsize = actual.size();	
		for(int i=0;i<tsize;i++) {
			int IntgerCost=Integer.parseInt(actual.get(i).getText().replace(",",""));	
			
			//String stringCost=actual.get(i).getText();
			//String actualCost=stringCost.replace(",","");
		//	int IntgerCost=Integer.parseInt(actualCost);		
			if(IntgerCost<=30000 && IntgerCost>=20000) {
				System.out.println("All Values within Sprecified Range 20 K and 30 K");
			}
		}
	}
}
