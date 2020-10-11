package stepdefs;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;

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


}
