package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageObjects.AddtoCartPageObjects;
import pageObjects.CmnPageObjects;
import pageObjects.ProductDescriptionObjects;
import pageObjects.SearchPageObject;

public class TestContextUI {
	
	private WebDriver driver;
	private SearchPageObject searchPageObject;
	private CmnPageObjects cmnPageObjects;
	private ProductDescriptionObjects productDescriptionObjects;
	private AddtoCartPageObjects addToCartPageObjects;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public SearchPageObject getSearchPageObject() {
		return searchPageObject;
	}
	
	public CmnPageObjects getCmnPageObjects() {
		return cmnPageObjects;
	}
	
	public ProductDescriptionObjects getproductDescriptionObjects() {
		return productDescriptionObjects;
	}
	
	public AddtoCartPageObjects getaddToCartPageObjects() {
		return addToCartPageObjects;
	}

	public void initializePageObjectClasses(WebDriver driver, Scenario scn) {
		searchPageObject = new SearchPageObject(driver, scn);
		cmnPageObjects = new CmnPageObjects(driver,scn);
		productDescriptionObjects = new ProductDescriptionObjects(driver, scn);
		addToCartPageObjects = new AddtoCartPageObjects(driver, scn);
		
	}
}
