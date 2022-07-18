package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import config.UtilityPage;

public class LoginPage extends UtilityPage {

	public static Logger log = LogManager.getLogger(LoginPage.class);

	@FindBy(xpath = "//button[@id='send2']")
	public WebElement loginBtn;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='pass']")
	public WebElement password;

	@FindBy(xpath = "")
	public WebElement logout;

	/*
	 * public LoginPage() {
	 *
	 * PageFactory.initElements(driver, this); }
	 */

	public void loginMethod(String user, String pass) {

		PageFactory.initElements(driver, this);
		assertEquals(getTitle(), "Customer Login");

		assertTrue(isEnabled(username));
		username.clear();
		username.sendKeys(user);
		log.info("User have enterd the username");

		assertTrue(isEnabled(password));
		password.clear();
		password.sendKeys(pass);
		log.info("User have enterd the password");

		assertTrue(isEnabled(loginBtn));
		log.info("User have clicked on login button");
		loginBtn.click();

		assertEquals(getTitle(), "My Accoun");

	}

	public void logoutMethod() {

		PageFactory.initElements(driver, this);
		Assert.assertTrue(isDisplayed(logout));
		waitforsec(3);
		logout.click();
	}
}
