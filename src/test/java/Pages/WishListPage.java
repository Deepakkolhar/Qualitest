package Pages;
import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage {

	WebDriver driver;

	By wish_list = By.xpath("//*[@id=\"blog\"]/div[3]/div[1]/div/div/div[3]/div[3]/a/i");
	By selected_item_list = By.xpath("//*[@id=\"yith-wcwl-form\"]/table/tbody");
	By first_item_price = By.xpath("//*[@id=\"yith-wcwl-row-20\"]/td[4]/ins/span");
	By second_item_price = By.xpath("//*[@id=\"yith-wcwl-row-14\"]/td[4]/ins/span");
	By third_item_price = By.xpath("//*[@id=\"yith-wcwl-row-22\"]/td[4]/ins/span");
	By fourth_item_price = By.xpath("//*[@id=\"yith-wcwl-row-15\"]/td[4]/ins/span");

	public void viewWishList(WebDriver driver2) {
		driver = driver2;
		driver.findElement(wish_list).click();
	}

	public void wishListCount(WebDriver driver2) {
		driver = driver2;
		WebElement TogetRows = driver.findElement(selected_item_list);
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));

		if (TotalRowsList.size() == 4) {
			System.out.println("4 items are in wish list");
		}
	}

	public int searchLowestPrice(WebDriver driver2) {
		driver = driver2;

		WebElement TogetRows = driver.findElement(selected_item_list);
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		BigDecimal minPrice = new BigDecimal (0.00);
		int minPriceIndex = 0;
		for(int i=0;i<TotalRowsList.size();i++) {
			WebElement RowValue = driver.findElement(selected_item_list);	
			WebElement CellValue = RowValue.findElement(By.xpath("//tr["+(i+1)+"]/td[4]/ins/span/bdi"));
			if(i==0){
				minPrice = new BigDecimal(CellValue.getText().replace("£", ""));
			}
			else{

				if(new BigDecimal(CellValue.getText().replace("£", "")).compareTo(minPrice)==-1) {
					minPrice = new BigDecimal(CellValue.getText().replace("£", ""));
					minPriceIndex = i;
				}
			}
		}

		System.out.println("Minprice is " +minPrice +"--> MinPrice found at"+minPriceIndex);

		return(minPriceIndex);
	}

	public void addLowestPriceItem(WebDriver driver2, int itemToClick) {

		WebElement TogetRows = driver.findElement(selected_item_list);
		WebElement addToCart = TogetRows.findElement(By.xpath("//tr["+(itemToClick+1)+"]/td[6]/a"));
		addToCart.click();
	}
}