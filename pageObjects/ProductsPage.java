package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MenuPage {

	@FindBy(css = "#shopping_cart_container")
	private WebElement cartBtn;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void chooseProduct(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	public void addToCart(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement el : list) {
			WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(titleEl).equalsIgnoreCase(name)) {
				WebElement addBtn = el.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
				click(addBtn);
				break;
			}
		}
	}

	public void removeFromCart(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement el : list) {
			WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(titleEl).equalsIgnoreCase(name)) {
				WebElement addBtn = el.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
				click(addBtn);
				break;
			}
		}
	}

	public void openCart() {
		click(cartBtn);
	}

	public void checkYourBudget(String itemPrice, double budget) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement el : list) {
			WebElement priceEl = el.findElement(By.cssSelector("div.inventory_item_description > div.pricebar > div"));
			if (getText(priceEl).equalsIgnoreCase(itemPrice)) {
				String item = getText(priceEl);
				item = item.replace("$", "");
				double Price = Double.parseDouble(item);
				if (budget >= Price) {
					WebElement addBtn = el.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
					click(addBtn);
					break;
				}
			}
		}
	}
}
