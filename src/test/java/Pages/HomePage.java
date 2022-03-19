package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	By sales = By.xpath("//*[@id=\"menu-item-306\"]/a");
	By first_product = By.xpath("//*[@id=\"site-content\"]/div/div/div/ul/li[1]/div/div[2]/div/div/a/span");
	By second_product = By.xpath("//*[@id=\"site-content\"]/div/div/div/ul/li[2]/div/div[2]/div/div/a/span");
	By third_product = By.xpath("//*[@id=\"site-content\"]/div/div/div/ul/li[3]/div/div[2]/div/div/a/span");
	By fourth_product = By.xpath("//*[@id=\"site-content\"]/div/div/div/ul/li[4]/div/div[2]/div/div/a/span");

	public void addProducts(WebDriver driver2) throws Exception {
		driver = driver2;

		driver.findElement(sales).click();
		driver.findElement(second_product).click();
		driver.findElement(fourth_product).click();
		driver.findElement(first_product).click();
		driver.findElement(third_product).click();
	}
}
