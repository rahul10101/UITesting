package stepdefs;

import java.util.ArrayList;

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
    	testContextUI.getDriver().close();
    	testContextUI.getaddToCartPageObjects().switchToDefaultWindowTab();
    	testContextUI.getSearchPageObject().CleartextBox();
    	testContextUI.getDriver().navigate().refresh();
    }
}

@When("Deleted one product from it.")
public void deleted_one_product_from_it() {
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
}
