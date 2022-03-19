package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CartPage;
import Pages.HomePage;
import Pages.WishListPage;
import io.cucumber.java.en.*;

public class AddToCart {

	WebDriver driver = null;
	WishListPage wishlistpage = new WishListPage();
	HomePage homepage = new HomePage(); 
	int itemToClick = 0;

	@Given("I add four different products to my wishlist")
	public void i_add_four_different_products_to_my_wishlist() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\ChromeDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.navigate().to("https://testscriptdemo.com/");
		driver.findElement(By.xpath("//*[@id=\"cc-window\"]/div[5]/a[1]")).click();

		homepage.addProducts(driver);

	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {

		wishlistpage.viewWishList(driver);
	}

	@Then("Find total four selected items in my wishlist")
	public void find_total_four_selected_items_in_my_wishlist() {

		wishlistpage.wishListCount(driver);
	}

	@When("i search for lowest price product")
	public void i_search_for_lowest_price_product() {

		itemToClick = wishlistpage.searchLowestPrice(driver);
	}

	@When("I am able to add lowest price project to my cart")
	public void i_am_able_to_add_lowest_price_project_to_my_cart() {

		wishlistpage.addLowestPriceItem(driver, itemToClick);
	}

	@Then("I am able to verify in my cart")
	public void i_am_able_to_verify_in_my_cart() {

		CartPage CartPage = new CartPage();
		CartPage.CheckCartPage(driver);
	}
}
