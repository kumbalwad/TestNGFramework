package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.UserData;
import pages.LoginPage;

public class LoginTest extends LoginPage {

	@BeforeMethod
	public void launchbrowser() {
		browserLaunch();
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "magentoUser", dataProviderClass = UserData.class)
	public void loginTestCase(String username, String password) {

		loginMethod(username, password);
	}
}
