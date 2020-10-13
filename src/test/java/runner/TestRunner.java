package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:features",
		glue="stepdefs",
		tags="@TC0015",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		
		monochrome = true, // display the console output in much readable way 
		strict=false, // will fail execution if there are undefined or pending steps 
		dryRun=false
		

		)
public class TestRunner {

}
