package stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver.Navigation;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCardStepdef extends TestBase{
	TestContextUI testContextUI;
	Scenario scn;
	
	public AddToCardStepdef(TestContextUI testContextUI) {
	this.testContextUI=testContextUI;	
	}
	
@Then("Select any product add in to Cart")
public void select_any_product_add_in_to_Cart() {
   testContextUI.getaddToCartPageObjects().ClickOnProductLink();
   testContextUI.getaddToCartPageObjects().switchToSecondWindowTab();  
}

@Then("Validate product Added Successfuly")
public void validate_product_Added_Successfuly() {
	testContextUI.getaddToCartPageObjects().ClickOnAddtoCartButton();
    testContextUI.getaddToCartPageObjects().ValidateActualProductandExpectedproductwithCount();
}
 
@When("I added {int} products in the cart")
public void i_added_products_in_the_cart(Integer proCount) throws Exception {
    for(int i= 0; i<proCount; i++) {
    	testContextUI.getSearchPageObject().search_TextBox(productList().get(i));
    	testContextUI.getSearchPageObject().click_on_Search_Button();
    	testContextUI.getSearchPageObject().ClickOnProductLink();
    	testContextUI.getSearchPageObject().switchToSecondWindowTab();
    	testContextUI.getaddToCartPageObjects().ClickOnAddtoCartButton();
    	//testContextUI.getDriver().close();
    	testContextUI.getaddToCartPageObjects().switchToDefaultWindowTab();
    	testContextUI.getSearchPageObject().CleartextBox();
    	testContextUI.getDriver().navigate().refresh();
    }
}

@When("Delete one product from it.")
public void delete_one_product_from_it() {
  testContextUI.getaddToCartPageObjects().ClickOnCart();
  testContextUI.getaddToCartPageObjects().ClickOnDelete();
}

@Then("validate cart should update accordigly or not")
public void validate_cart_should_update_accordigly_or_not() {
   testContextUI.getaddToCartPageObjects().ValidateActualProductandExpectedproductwithCount();
}

public static ArrayList<String> productList(){
	ArrayList<String> productList = new ArrayList<>();
	productList.add("Laptop");
	productList.add("Samsung TV");
	return productList();
}

@When("I Search products as Laptop and Added Into Cart")
public void i_Search_products_as_Laptop_and_Added_Into_Cart() throws InterruptedException {
   testContextUI.getSearchPageObject().search_TextBox("Laptop");
   testContextUI.getSearchPageObject().click_on_Search_Button();
   testContextUI.getSearchPageObject().ClickOnProductLink();
   testContextUI.getSearchPageObject().switchToSecondWindowTab();
   testContextUI.getaddToCartPageObjects().ClickOnAddtoCartButton();
   Thread.sleep(3000);
   testContextUI.getDriver().close();
   testContextUI.getaddToCartPageObjects().switchToDefaultWindowTab();
   testContextUI.getSearchPageObject().CleartextBox();
   testContextUI.getDriver().navigate().refresh();
}

@Then("I get message as {string}")
public void i_get_message_as(String msg) {
	testContextUI.getaddToCartPageObjects().ValidateCartIsEmpty(msg);
}

@When("I Search products as Earphones and Added Into Cart")
public void i_Search_products_as_Earphones_and_Added_Into_Cart() throws InterruptedException {
	testContextUI.getSearchPageObject().search_TextBox("Earphones");
	   testContextUI.getSearchPageObject().click_on_Search_Button();
	   testContextUI.getSearchPageObject().ClickOnProductLink();
	   testContextUI.getSearchPageObject().switchToSecondWindowTab();
	   testContextUI.getaddToCartPageObjects().ClickOnAddtoCartButton();
	   Thread.sleep(3000);
	   testContextUI.getDriver().close();
	   testContextUI.getaddToCartPageObjects().switchToDefaultWindowTab();
	   testContextUI.getSearchPageObject().CleartextBox();
	   testContextUI.getDriver().navigate().refresh();
}

@When("I search for and add single product of each category as below")
public void i_search_for_and_add_single_product_of_each_category_as_below(List<String> list) throws Exception {
  
	for(int i = 0;i<list.size(); i++) {
		testContextUI.getSearchPageObject().search_TextBox(list.get(i));
		 testContextUI.getSearchPageObject().click_on_Search_Button();
		 i_click_on_first_product_in_the_Search_Result();
		 i_click_on_Add_To_Cart_button();
		 testContextUI.getDriver().close();
		 testContextUI.getDriver().switchTo().window((String)testContextUI.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
		 testContextUI.getSearchPageObject().CleartextBox();		 
	}
	
}

@Then("All the products should be added in the cart")
public void all_the_products_should_be_added_in_the_cart() {
  testContextUI.getaddToCartPageObjects().ClickOnCart();
  testContextUI.getaddToCartPageObjects().ValidateNumbersOfProducts();
}

public void i_click_on_first_product_in_the_Search_Result() {
	testContextUI.getSearchPageObject().ClickOnProductLink();
}

public void i_click_on_Add_To_Cart_button() throws Exception {
	testContextUI.getDriver().switchTo().window((String) testContextUI.getDriver().getWindowHandles().toArray()[1]);
	testContextUI.getaddToCartPageObjects().ClickOnAddtoCartButton();
	Thread.sleep(15000);
}
}
