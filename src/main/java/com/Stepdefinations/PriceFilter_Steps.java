package com.Stepdefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceFilter_Steps {

	@Given("the user is on the Myntra site")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
	}

	@When("the user searches for {string} sunglasses")
	public void the_user_searches_for_sunglasses(String brand) {
		WebElement searchInput = KeywordsDemo.getDriver()
				.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"));
		searchInput.sendKeys(brand, Keys.ENTER);
	}

	@And("filters results by gender")
	public void filters_results_by_gender() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("ul.gender-list>li>label:nth-of-type(1)")).click();
	}

	@And("applies a price filter")
	public void applies_a_price_filter() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("ul.price-list>li:nth-of-type(1)")).click();
	}

	@Then("the user should see {string} sunglasses in the search results within the specified price range")
	public void the_user_should_see_ray_ban_sunglasses_in_the_search_results_within_the_specified_price_range(String brand) {
		FluentWait<RemoteWebDriver> wait = new FluentWait<>(KeywordsDemo.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h4[class=\"product-product\"]"), 1));

		List<WebElement> productList = KeywordsDemo.getDriver()
				.findElements(By.cssSelector("h4[class=\"product-product\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitle : productList) {
			String text = productTitle.getText();
			System.out.println("Checking " + text);
			softly.assertTrue(text.contains(brand) && text.contains("Sunglasses"));
		}

		softly.assertAll();
		KeywordsDemo.getDriver().quit();
	}

}
