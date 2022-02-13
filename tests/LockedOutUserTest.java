package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LockedOutUserTest extends BaseTest {

	@Test
	public void tc4() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("locked_out_user", "secret_sauce");

		String expected = "Epic sadface: Sorry, this user has been locked out.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
		System.out.println(actual + "|| " + expected);
	}

}
