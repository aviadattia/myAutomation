package tests;

import pageObjects.LoginPage;
import org.testng.annotations.BeforeMethod;

public class BaseMethod extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");
	}
}
