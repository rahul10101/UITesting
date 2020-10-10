package stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import context.TestContextUI;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepdefs {

	TestContextUI testContextUI;
	
	
	

	public HomePageStepdefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;

	}

	@Then("Below Headers are Displayed")
	public void below_Headers_are_Displayed(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			testContextUI.getCmnPageObjects().validateElementPresentInHeaderSection(list.get(i));
		}
	}
	
	@When("I click on Login And Enter Valid Creadentials")
	public void i_click_on_Login_And_Enter_Valid_Creadentials() {
	   testContextUI.getCmnPageObjects().click_Sign_In();
	   testContextUI.getCmnPageObjects().email_or_phone("9273430608");
	   testContextUI.getCmnPageObjects().click_ContinueButton();
	   testContextUI.getCmnPageObjects().enterPassword("54@9$%#");
	   testContextUI.getCmnPageObjects().click_Login_Button();
	}

	@Then("I login Successfully")
	public void i_login_Successfully() {
	  testContextUI.getCmnPageObjects().moveCursorOnSignIn();
	  testContextUI.getCmnPageObjects().Sign_Out();
	}
}
