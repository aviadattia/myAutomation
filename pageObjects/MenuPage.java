package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css = ".shopping_cart_link")
	private WebElement cartBtn;
	@FindBy(css = ".product_sort_container")
	private WebElement sortBtn;

	// menu options
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement closeMenuBtn;
	@FindBy(css = "#inventory_sidebar_link")
	private WebElement allProductsBtn;
	@FindBy(css = "#about_sidebar_link")
	private WebElement about;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logoutBtn;
	@FindBy(css = "#reset_sidebar_link")
	private WebElement resetBtn;

	// empty cart or not
	@FindBy(css = "#shopping_cart_container > a > span")
	private WebElement productsCounter;
	@FindBy(css = "#shopping_cart_container > a")
	private WebElement emptyCart;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public void goToCart() {
		click(cartBtn);
	}

	public void sortMenu() {
		click(sortBtn);
	}

	public void openMenu() {
		click(menuBtn);
	}

	public void closeMenu() {
		click(closeMenuBtn);
	}

	public void AllProducts() {
		click(allProductsBtn);
	}

	public void About() {
		click(about);
	}

	public void Logout() {
		click(logoutBtn);
	}

	public void Reset() {
		click(resetBtn);
	}

	// validation
	public int getCounter() {
		String s = getText(productsCounter);
		int num = Integer.parseInt(s);
		return num;
	}

	public boolean isLoginPass() {
		if (menuBtn.isDisplayed()) {
			return true;
		}
		return false;
	}
}
