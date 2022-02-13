package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutInfo;
import pageObjects.FinishOrder;
import pageObjects.LastPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class MenuOptionsTest extends BaseMethod {

	@Test
	public void tc21() {

		MenuPage mp = new MenuPage(driver);
		mp.openMenu();
		mp.AllProducts();
		mp.closeMenu();
		ProductsPage psp = new ProductsPage(driver);
		psp.addToCart("Sauce Labs Backpack");
		psp.addToCart("Sauce Labs Bike Light");
		psp.addToCart("Sauce Labs Bolt T-Shirt");
		psp.addToCart("Sauce Labs Fleece Jacket");
		psp.addToCart("Sauce Labs Onesie");
		psp.addToCart("Test.allTheThings() T-Shirt (Red)");

		mp.openMenu();
		mp.Logout();
		LoginPage lp = new LoginPage(driver);
		String expected = "Password for all users:";
		String actrual = lp.getText(driver.findElement(By.cssSelector(".login_password h4")));
		Assert.assertEquals(actrual, expected);
		System.out.println(expected + "||" + actrual);
	}

	@Test
	public void tc22() {
		MenuPage mp = new MenuPage(driver);
		System.out.println("items in cart = " + mp.getCounter());
		mp.openMenu();
		mp.Reset();

		// the button "add to cart" is still pressed after the reset and you can not add
		// because the button is in a remove status

		driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).click();
		mp.goToCart();
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("patrick", "star", "bb123");
		FinishOrder fo = new FinishOrder(driver);
		fo.checkBill();
		LastPage lastp = new LastPage(driver);
		lastp.backToStart();
		mp.openMenu();
		mp.About();
	}
}
