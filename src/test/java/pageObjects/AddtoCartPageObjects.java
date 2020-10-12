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

public class AddtoCartPageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(SearchPageObject.class);
	Scenario scn;
	
	private By product_List = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
	private By addToCart_Button = By.xpath("//input[@title='Add to Shopping Cart']");
	private By Cart_products_Added = By.xpath("//div[@id='nav-cart-count-container']/span[1]");
	private By delete_1st_Product = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");
	//private By added_Product_Name = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");
	private By cart_empty_msg =By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']");
	
	public AddtoCartPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s; 
	}
	public String ClickOnProductLink() {
		List<WebElement> list = getListOfWebElements(product_List);
		clickElement(list.get(0));
		scn.write("Clicked on First Product Link");
		
		return list.get(0).getText();
		}
	public void ValidateCartIsEmpty(String msg){
		String actual=getText(cart_empty_msg);
		Assert.assertEquals(msg, actual);
		scn.write("After the product is deleted message displayed as: "+"Your Amazon Basket is empty");
		
	}
	public void ClickOnAddtoCartButton() {
		clickElement(addToCart_Button);
		scn.write("Clicked on Add to Cart Product Button");
	
		}
	public void ClickOnCart() {
		clickElement(Cart_products_Added);
		scn.write("Clicked on Cart Product ");
	
		}
	public void ClickOnDelete() {
		clickElement(delete_1st_Product);
		scn.write("Delete product ");
	
		}
	
	public void ValidateActualProductandExpectedproductwithCount() {
		String added_product = getText(Cart_products_Added);
		scn.write("Actual No. of Products in the list " +added_product);
		if (getText(Cart_products_Added).contains("1")) {
			Assert.assertTrue(true);
			scn.write("Count Of The Cart Displayed As 1");
		}else {
			Assert.fail("Count Of The Cart not Displayed As 1");
		}
	}
	
	public void ValidateActualProductandExpectedproductwithCountinBasket() {
		String added_product = getText(Cart_products_Added);
		scn.write("Actual No. of Products in the list " +added_product);
		if (getText(Cart_products_Added).contains("3")) {
			Assert.assertTrue(true);
			scn.write("Count Of The Cart Displayed As 3");
		}else {
			Assert.fail("Count Of The Cart not Displayed As 3");
		}
	}
	

}

