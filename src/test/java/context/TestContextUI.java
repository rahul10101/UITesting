package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageObjects.SearchPageObject;

public class TestContextUI {
	
	private WebDriver driver;
	private SearchPageObject searchPageObject;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public SearchPageObject getSearchPageObject() {
		return searchPageObject;
	}

	public void initializePageObjectClasses(WebDriver driver, Scenario scn) {
		searchPageObject = new SearchPageObject(driver, scn);
	}
}
