package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends MenuPage {
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;
	@FindBy(css = "#continue-shopping")
	private WebElement countinueShopBtn;
	
	@FindBy(css = ".title")
	private WebElement yourCartLabel;

	public YourCartPage(WebDriver driver) {
		super(driver);
	}

	public void checkout() {
		click(checkoutBtn);
	}
	
	public void continueShop() {
		click(countinueShopBtn);
	}
		
	public void removeFromCart(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".cart_item"));
		for (WebElement el : list) {
			WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(titleEl).equalsIgnoreCase(name)) {
				WebElement addBtn = el.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
				click(addBtn);
				break;
			}
		}
	}
	
	public boolean isYourCartPage() {
		if (getText(yourCartLabel).equalsIgnoreCase("YOUR CART")) {
			return true;
		}
		return false;
	}
}
