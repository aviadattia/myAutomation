package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class DDT extends BaseTest {

	@Test(dataProvider = "getData", description = "use incorrect login information")
	public void tc27(String user, String password) {
		// login failed

		LoginPage lp = new LoginPage(driver);
		lp.Login(user, password);

		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = {

				{ "standard", "secret_sauce" },
				{ "locked", "secret_sauce" },
				{ "problem", "secret_sauce" },
				{ "performance", "secret_sauce" },

		};
		return myData;
	}
}
