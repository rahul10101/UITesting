package stepdefs;

import java.util.List;

import context.TestContextUI;
import cucumber.api.java.en.Then;

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

}
