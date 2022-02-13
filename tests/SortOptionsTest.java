package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;

public class SortOptionsTest extends BaseTest {

	@Test
	public void tc13() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");

		Select s = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
		s.selectByValue("hilo");
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Fleece Jacket");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		pp.sleep(500);
		String expected = "Price (high to low)";
		String actual = psp.getText(driver.findElement(By.cssSelector("[value='hilo']")));
		Assert.assertEquals(actual, expected);
		System.out.println(expected + "||" + actual);
	}

	@Test
	public void tc14() {
		Select s = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
		s.selectByIndex(1);
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Bike Light");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		pp.sleep(500);
		String expected = "Name (Z to A)";
		String actual = psp.getText(driver.findElement(By.cssSelector("[value='za']")));
		Assert.assertEquals(actual, expected);
		System.out.println(expected + "||" + actual);
	}

	@Test
	public void tc15() {
		Select s = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
		s.selectByVisibleText("Price (low to high)");
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Backpack");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		String expected = "Price (low to high)";
		String actual = psp.getText(driver.findElement(By.cssSelector("[value='lohi']")));
		Assert.assertEquals(actual, expected);
		System.out.println(expected + "||" + actual);
	}

	@Test
	public void tc16() {
		ProductsPage psp = new ProductsPage(driver);
		psp = new ProductsPage(driver);
		psp.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		pp.sleep(500);
		String expected = "Name (A to Z)";
		String actual = psp.getText(driver.findElement(By.cssSelector("[value='az']")));
		Assert.assertEquals(actual, expected);
		System.out.println(expected + "||" + actual);
	}
}
