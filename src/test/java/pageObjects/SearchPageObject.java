package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.Interact;

public class SearchPageObject extends Interact {

	private static final Logger logger = LogManager.getLogger(SearchPageObject.class);
	Scenario scn;

	private By search_box = By.id("twotabsearchtextbox");
	private By search_Button = By.xpath("//input[@value='Go']");
	private By product_List = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By product_List_all = By.xpath("//a[@class='a-link-normal a-text-normal']//span[@class='a-size-medium a-color-base a-text-normal']");
	private By pagination_page = By.xpath("//li[@class='a-selected']");
	private By Previos_Page_click = By.xpath("//li[@class='a-disabled'][position()=1]");
	private By next_page_tab = By.xpath("//li[@class='a-last']");
	private By autosuggetion_options = By.xpath("//div[@class='s-suggestion']");
	
	public SearchPageObject(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}

	public void search_TextBox(String text) {
		setElement(search_box, text);
		logger.info("Value enetered in search box: " + text);
		// takeScreenShotAndAttachInReport(scn);
	}

	public void click_on_Search_Button() {
		clickElement(search_Button);
		logger.info("Clicked on Search Button");
	}
	
	public void CleartextBox() {
		clearSearchtextBox(search_box);
		takeScreenShotAndAttachInReport(scn);
	}
	
	public String ClickOnProductLink() {
	List<WebElement> list = getListOfWebElements(product_List_all);
	System.out.println("List of products:" +list);
	clickElement(list.get(0));
	scn.write("Clicked on First Product Link");
	return list.get(0).getText();
	}
	
	public void search_Product_List(String productName) {
		List<WebElement> productList = getListOfWebElements(product_List);
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Product Not Correctly Displayed in the Search result. product at index:" + (i + 1));
			}
		}

	}
	
	public void search_ListOf_Products() {
		List<WebElement> productList = getListOfWebElements(product_List);
		for (int i = 0; i < productList.size(); i++) {
			String product_Name = productList.get(i).getText();
			scn.write("Clicked on First Product Link" +product_Name);
		}
		logger.info("product List Displayed Successfully");
	}
	
	public void paginationpageValidations(){
		validateElementIsDisplayed(pagination_page);
		validateElementIsEnabled(pagination_page);
		validateElementIsSelected(pagination_page);
		scn.write("First Page is Displayed,Enabled and Selected");
		
	}
	
	public void paginationPrevios_and_Next_pageValidation(){
		validateElementIsDisplayed(Previos_Page_click);
		validateElementIsDisplayed(next_page_tab);
		scn.write("Next Page and Previous page Button Available ");		
	}
	
	public void autosuggetionOptionsValidation(String actualproductName) {
		List<WebElement> autosuggetionOptionsList = getListOfWebElements(autosuggetion_options);
		for(int i=3;i<autosuggetionOptionsList.size();i++) {
			if (autosuggetionOptionsList.get(i).getText().toLowerCase().contains(actualproductName.toLowerCase())) {
				Assert.assertTrue(true);
			}else {
				Assert.fail("Product not correctly displayed in the search result. Product at index: " + (i+1));
			}
		}
	}

}
