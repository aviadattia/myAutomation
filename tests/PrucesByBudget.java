package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class PrucesByBudget extends BaseTest {
	@Test
	public void tc32() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");

		ProductsPage psp = new ProductsPage(driver);
		psp.checkYourBudget("$7.99", 8);
		int expected = 1;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
	}

	@Test
	public void tc33() {
		ProductsPage psp = new ProductsPage(driver);
		psp.checkYourBudget("$29.99", 29.99);
		int expected = 2;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
	}

	@Test
	public void tc34() {
		ProductsPage psp = new ProductsPage(driver);
		psp.checkYourBudget("$49.99", 49.98);
		int expected = 2;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
	}
}
