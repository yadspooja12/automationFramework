package homePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Test.YourLogoTestBase;
import pageobjects.SearchPage;
import static com.google.common.truth.Truth.*;

public class SortByObjects extends YourLogoTestBase {

	
	SearchPage search;

	@BeforeMethod
	public void setUp() {
		initialize();
		
		search = new SearchPage(driver);
	}

	
	@Test (description="Verify the sorting in ascending order on search page")
	public void sortByLowerstPrice() {
		search.searchTextBox.click();
		search.searchTextBox.sendKeys("printed dress");
		search.searchButton.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(search.sortHover));
		search.sortHover.click();
		Select sortOptions = new Select(search.ProductSort);
		sortOptions.selectByValue("price:asc");
		
		List<WebElement> price = search.productPrices;
		List<Double> prices = new ArrayList<Double>();

		for (WebElement a : price) {

			String priceText = a.getText();
			System.out.println(priceText);

			if (!priceText.isEmpty()) {
				String replacePriceText = priceText.replace("$", "");
				double priceValue = Double.parseDouble(replacePriceText);
				prices.add(priceValue);
			}
		}

		assertThat(prices).isOrdered();
		System.out.println(prices);

	}

	@AfterMethod
	public void closeDriver() {
		if (driver != null)
			driver.close();
	}

}
