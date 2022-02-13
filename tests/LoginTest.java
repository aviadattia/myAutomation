package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void tc1() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("", "");
		String expected = "Epic sadface: Username is required";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
		System.out.println(actual + "|| " + expected);
	}

	@Test
	public void tc2() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "");
		String expected = "Epic sadface: Password is required";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
		System.out.println(actual + "|| " + expected);
	}

	@Test
	public void tc3() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_u", "s_sauce");
		String expected = "Epic sadface: Username and password do not match any user in this service" + "";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
		System.out.println(actual + "|| " + expected);
	}
}
