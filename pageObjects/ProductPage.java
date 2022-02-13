package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MenuPage {
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private WebElement cartBtn;
	@FindBy(css = "#back-to-products")
	private WebElement backBtn;
	@FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
	private WebElement removeBtn;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void addToCart() {
		click(cartBtn);
	}

	public void back() {
		click(backBtn);
	}

	public void removeCart() {
		click(removeBtn);
	}
}
