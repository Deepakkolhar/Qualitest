package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;

	By CartPage = By.xpath("//*[@id=\"blog\"]/div[2]/div[1]/div/div/div[3]/div[1]/div/div/a/i");
	By ProductName = By.xpath("//*[@id=\"site-content\"]/div/div/article/div/div/div[1]/div/form/table/tbody/tr[1]/td[3]/a");

	public void CheckCartPage(WebDriver driver2) {
		driver = driver2;
		driver.findElement(CartPage).click();
		if(driver.findElement(ProductName).getText().equals("Bikini")) {
			System.out.println("Correct product added to Cart");
		}
	}
}