package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageObjects.CmnPageObjects;
import pageObjects.SearchPageObject;

public class TestContextUI {
	
	private WebDriver driver;
	private SearchPageObject searchPageObject;
	private CmnPageObjects cmnPageObjects;
	
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

	public void initializePageObjectClasses(WebDriver driver, Scenario scn) {
		searchPageObject = new SearchPageObject(driver, scn);
		cmnPageObjects = new CmnPageObjects(driver,scn);
	}
}
