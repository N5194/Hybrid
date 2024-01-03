package com.testcases;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Base.TestBase;
import com.Pages.Mango_Result_Page;
import com.Pages.Search_Mango_Product_Page;
import com.exception.InvalidSelectorException;

public class TestCase extends TestBase {
	@Test
	public void verifyManagoBrandProducts() {

		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("MANGO", Keys.ENTER);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h3[class=\"product-brand\"]"), 1));
		List<WebElement> list = driver.findElements(By.cssSelector("h3[class=\"product-brand\"]"));
		SoftAssert softy = new SoftAssert();

		for (WebElement productTitle : list) {
			String text = productTitle.getText();
			System.out.println("Checking" + text);
			softy.assertTrue(text.contains("MANGO"));
		}
		softy.assertAll();

	}

	@Test
	public void verifyManagoBrandProductsUsingPage() throws InvalidSelectorException {
		Search_Mango_Product_Page mango = new Search_Mango_Product_Page();
		mango.enterTextToSearch("MANGO", Keys.ENTER);
		Mango_Result_Page m = new Mango_Result_Page();
		m.verifyproductTitlesContains("MANGO");
	}
}
