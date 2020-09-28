package utils.manager.driver.factory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends DriverManager{
	@Override
	protected void initDriver() {
		driver = new FirefoxDriver();
	}
}
