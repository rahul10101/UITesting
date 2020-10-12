package stepdefs;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;

public class SearchStepDefs extends TestBase{

	TestContextUI testContextUI;
	Scenario scn;
	String productClickedTextExpected;
	
	public SearchStepDefs(TestContextUI testContextUI) {
	this.testContextUI=testContextUI;
		
	}
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@Given("I have browser opened and url navigated")
	public void i_have_browser_opened_and_url_navigated() throws Exception {
	  DriverManager driverManager = DriverFactory.getDriverManager("chrome");
	  WebDriver driver = driverManager.getDriver();
	  driverManager.maximizeBrowser();
	  driverManager.navigateToDriver(serverUI);
	  scn.write("Chrome Driver invoked and URL navigated as: " + serverUI);
	  scn.write("Search was sucessfull");
	  testContextUI.setDriver(driver);
	  testContextUI.initializePageObjectClasses(driver, scn);
	 
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product)  {
	testContextUI.getSearchPageObject().search_TextBox(product);
	testContextUI.getSearchPageObject().click_on_Search_Button();
	scn.write("Search was sucessfull");
	}

	@Then("product list should apper pertaining to the product search as {string}")
	public void product_list_should_apper_pertaining_to_the_product_search_as(String productname) {
		testContextUI.getSearchPageObject().search_Product_List(productname);
	}
	@When("I click on hamberger menu")
	public void i_click_on_hamberger_menu() {
	  testContextUI.getCmnPageObjects().click_On_Hamberger_Menu();
	}

	@When("I click on hamberger menu with category as {string}")
	public void i_click_on_hamberger_menu_with_category_as(String category) throws Exception {
	   testContextUI.getCmnPageObjects().click_on_Product(category);
	   Thread.sleep(9000);
	}

	@When("I click on hamberger menu with sub category as {string}")
	public void i_click_on_hamberger_menu_with_sub_category_as(String subcategory) throws InterruptedException {
	    testContextUI.getCmnPageObjects().click_on_Product(subcategory);
	    Thread.sleep(9000);
	}

	@Then("Search result are displayed for product related to {string}")
	public void search_result_are_displayed_for_product_related_to(String products) {
	   testContextUI.getCmnPageObjects().validatePageTitleMatch(products);
	}

	@When("I click on any product in the Search Result")
	public void i_click_on_any_product_in_the_Search_Result() {
		productClickedTextExpected = testContextUI.getSearchPageObject().ClickOnProductLink();
	}

	@Then("I am able to see product description and details in new tab")
	public void i_am_able_to_see_product_description_and_details_in_new_tab()  {
	   testContextUI.getproductDescriptionObjects().switchToSecondWindowTab();
	   testContextUI.getproductDescriptionObjects().ValidateProducDescriptionHeader(productClickedTextExpected);
	   testContextUI.getproductDescriptionObjects().switchToDefaultWindowTab();
	}

	@Then("Below Search product refinement should displayed")
	public void below_Search_product_refinement_should_displayed(List<String> list) {
	  for(int i=0; i<list.size();i++) {
		  testContextUI.getCmnPageObjects().validateElementPresentOrNot(list.get(i));
	  }
	}

	@Then("product should be displayed sorted by price range")
	public void product_should_be_displayed_sorted_by_price_range() {
	   testContextUI.getCmnPageObjects().click_on_Price_range();
	   testContextUI.getproductDescriptionObjects().ValidatePriceRange();
	   
	}
	
	@Then("Pegination panel with products of first page are displayed by default")
	public void pegination_panel_with_products_of_first_page_are_displayed_by_default() {
		
	   testContextUI.getSearchPageObject().search_ListOf_Products();
	
	}
	@Then("page links of previous page and next page workign as per expectation")
	public void page_links_of_previous_page_and_next_page_workign_as_per_expectation() {
	   testContextUI.getSearchPageObject().paginationpageValidations();
	   testContextUI.getSearchPageObject().paginationPrevios_and_Next_pageValidation();
	}
	
	@After
	public void CleanUp(Scenario s) {
		
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)testContextUI.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		
		testContextUI.getDriver().quit();
		scn.write("Browser is Closed");
	}
	
	@When("I search for product as {string} in search box")
	public void i_search_for_product_as_in_search_box(String product)  {
	testContextUI.getSearchPageObject().search_TextBox(product);
	scn.write("Search was sucessfull");
	}
	
	@Then("I am able to see autosuggetion option having keyword {string} .")
	public void i_am_able_to_see_autosuggetion_option_having_keyword(String actualproductName)  {
	  testContextUI.getSearchPageObject().autosuggetionOptionsValidation(actualproductName);
	}

	@When("I Search products and Added Into Cart")
	public void i_Search_products_and_Added_Into_Cart(List<String> productList) throws Exception  {
		
		for(int i=0; i<productList.size();i++) {
			testContextUI.getSearchPageObject().search_TextBox(productList.get(i));
			testContextUI.getSearchPageObject().click_on_Search_Button();
			testContextUI.getSearchPageObject().ClickOnProductLink();
			testContextUI.getaddToCartPageObjects().switchToSecondWindowTab();
			Thread.sleep(5000);
			testContextUI.getaddToCartPageObjects().ClickOnAddtoCartButton();
			testContextUI.getDriver().close();
			testContextUI.getaddToCartPageObjects().switchToDefaultWindowTab();
			testContextUI.getDriver().navigate().refresh();
			testContextUI.getSearchPageObject().CleartextBox();
			
		}
	}

	@Then("The Subtotal Is Total Of All Products In Cart")
	public void the_Subtotal_Is_Total_Of_All_Products_In_Cart() {
	  testContextUI.getaddToCartPageObjects().ValidateActualProductandExpectedproductwithCountinBasket();
	}


}
