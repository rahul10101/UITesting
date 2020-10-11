package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.Interact;

public class CmnPageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(SearchPageObject.class);
	Scenario scn;
	
	private By hamberger_Menu = By.id("nav-hamburger-menu");	
	private By amazon_logo =By.xpath("//span[@class='nav-sprite nav-logo-base']");
	private By account_and_Lists = By.xpath("//span[@class='nav-line-2 nav-long-width']");
	private By return_and_orders = By.xpath("//*[@id='nav-orders']/span[2]");
	private By try_prime = By.xpath("//span[@class='nav-line-2 ']");
	private By cart = By.xpath("[@id='nav-cart-text-container']/span[2]");
	private By department =By.xpath("//div[@id='n-title']/span");
	private By avg_customert_rev =By.xpath("//div[@id='p_72-title']/span");
	private By brand =By.xpath("//*[@id='p_89-title']/span");
	private By filter_price =By.xpath("//*[@id='p_36-title']/span");
	private By price_range =By.xpath("//li[@id='p_36/7252029031']/span/a/span");
	
	private By sign_In_Button = By.xpath("//*[@id='nav-link-accountList']/div/span");
	private By email_or_phone_textbox = By.xpath("//*[@id='ap_email']");
	private By Login_Continue = By.xpath("//input[@class='a-button-input']");
	private By password = By.xpath("//input[@id='ap_password']");
	private By login_button = By.xpath("//input[@id='signInSubmit']");
	private By sign_Out = By.xpath("//*[@id='nav-item-signout']/span");
	
	private String hamburger_menu_category_link_xpath = "//div[@id='hmenu-content']/ul[8]/li['%s']";
	private String hamburger_menu_sub_category_link_xpath = "//div[@id='hmenu-content']/ul[8]/li['%s']";
	
	public CmnPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void click_Sign_In() {
		clickElement(sign_In_Button);
	}
	
	public void Sign_Out() {
		DisplayedorNot(sign_Out);
		scn.write("Login Successfully and verified");
		takeScreenShotAndAttachInReport(scn);
	}
	public void email_or_phone(String text) {
		setElement(email_or_phone_textbox, text);
		logger.info("Entered Email or phone ");
		// takeScreenShotAndAttachInReport(scn);
	}
	
	public void click_ContinueButton() {
		clickElement(Login_Continue);
	}
	
	public void enterPassword(String text) {
		setElement(password, text);
		logger.info("Entered Password");
		// takeScreenShotAndAttachInReport(scn);
	}
	
	public void click_Login_Button() {
		clickElement(login_button);
	}
	
	public void moveCursorOnSignIn() {
		moveToCursorOnElement(sign_In_Button);
		takeScreenShotAndAttachInReport(scn);
	}
	public void click_On_Hamberger_Menu() {
		clickElement(hamberger_Menu);
	}
	
	public void click_on_Hamberger_Menu(String linkText) {
		By byElement = By.xpath(String.format(hamburger_menu_category_link_xpath,linkText));
		clickElement(byElement);
		scn.write("Clicked on Hamburger Menu Category link: " + linkText);
		logger.info("Clicked on Hamburger Menu Category link: " + linkText);
		
	}
	
	public void click_on_Product(String linkText) {
		By byElement = By.xpath(String.format(hamburger_menu_sub_category_link_xpath,linkText));
		clickElement(byElement);
		scn.write("Clicked on Hamburger Menu SubCategory link: " + linkText);
		logger.info("Clicked on Hamburger Menu SubCategory link: " + linkText);
	}
	
	public void click_on_Price_range() {
			clickElement(price_range);
		}
		
	
	public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals(true, b);
		scn.write("Page title matched: " + expectedTitle );
	}	
	
	public void validateElementPresentInHeaderSection(String text) {
		
		boolean b=false;
		switch(text.toLowerCase().trim()) {
		
		case "hamberger_Menu":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;			
		case "amazon_logo":
			b = validateElementIsDisplayed(amazon_logo);
			break;
		case "account_and_Lists":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "return_and_orders":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "try_prime":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "cart":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "department":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "avg_customert_rev":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "brand":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
		case "filter_price":
			b = validateElementIsDisplayed(hamberger_Menu);
			break;
	
	
		}
		
	}
	public void validateElementPresentOrNot(String text) {
		
			boolean b=false;
			switch(text.toLowerCase().trim()) {
		
		case "amazon_logo":
			b = validateElementIsDisplayed(amazon_logo);
			break;
		
		case "department":
			b = validateElementIsDisplayed(department);
			break;
		case "avg_customert_rev":
			b = validateElementIsDisplayed(avg_customert_rev);
			break;
		case "brand":
			b = validateElementIsDisplayed(brand);
			break;
		case "filter_price":
			b = validateElementIsDisplayed(filter_price);
			break;
			}
		}
}