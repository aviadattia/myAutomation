package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutInfo;
import pageObjects.FinishOrder;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;
import utils.Utils;

public class PerformanceTestingUserTest extends BaseTest {

	@Test
	public void tc5() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.Login("performance_glitch_user", "secret_sauce");
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Backpack");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.goToCart();
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("frank", "costanza", "123456");

		FinishOrder fo = new FinishOrder(driver);
		fo.checkBill();
		String expected = "THANK YOU FOR YOUR ORDER";
		String actual = fo.getText(driver.findElement(By.cssSelector(".complete-header")));
		Assert.assertEquals(actual, expected);
		System.out.println("expected = " + expected + "||" + "actual = " + actual);
		Thread.sleep(2000);
		driver.get(Utils.readProperty("url"));
	}

	@Test // COMPARE TIMES WITH TestNG REPORTS Standard users VS performance glitch user
	public void tc31() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Backpack");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.goToCart();
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("frank", "costanza", "123456");

		FinishOrder fo = new FinishOrder(driver);
		fo.checkBill();
		String expected = "THANK YOU FOR YOUR ORDER";
		String actual = fo.getText(driver.findElement(By.cssSelector(".complete-header")));
		Assert.assertEquals(actual, expected);
		System.out.println("expected = " + expected + "||" + "actual = " + actual);
		driver.get(Utils.readProperty("url"));
	}
}
