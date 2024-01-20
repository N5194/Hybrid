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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HnMproducts_Steps {

	@Given("user is on the Myntra website")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("the user searches for {string} products")
	public void the_user_searches_for_products(String searchTerm) {
		WebElement searchInput = KeywordsDemo.getDriver()
				.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"));
		searchInput.sendKeys(searchTerm, Keys.ENTER);

	}

	@Then("the user should see {string} products in the search results")
	public void the_user_should_see_h_m_products_in_the_search_results(String brand) {
		FluentWait<RemoteWebDriver> wait = new FluentWait<>(KeywordsDemo.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h3[class=\"product-brand\"]"), 1));

		List<WebElement> productList = KeywordsDemo.getDriver()
				.findElements(By.cssSelector("h3[class=\"product-brand\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitle : productList) {
			String text = productTitle.getText();
			System.out.println("Checking " + text);
			softly.assertTrue(text.contains(brand));
		}

		softly.assertAll();
		KeywordsDemo.getDriver().close();
	}

}
