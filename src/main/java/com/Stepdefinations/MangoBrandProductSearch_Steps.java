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
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MangoBrandProductSearch_Steps {
	SoftAssert softy = new SoftAssert();

	@Given("User is open url Myntra website")
	public void userIsOnMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		keywords.getDriver().manage().window().maximize();
	}

	@When("User searches for {string} brand products")
	public void user_searches_for_brand_products(String brandName) {
		KeywordsDemo.getDriver()
				.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys(brandName, Keys.ENTER);

	}

	@Then("User verifies that all displayed products belong to the {string} brand")
	public void user_verifies_that_all_displayed_products_belong_to_the_mango_brand(String brandName) {
		Wait<RemoteWebDriver> wait = new FluentWait<>(KeywordsDemo.getDriver()).pollingEvery(Duration.ofMillis(500))
				.withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h3[class=\"product-brand\"]"), 1));
		List<WebElement> list = KeywordsDemo.getDriver().findElements(By.cssSelector("h3[class=\"product-brand\"]"));

		for (WebElement productTitle : list) {
			String text = productTitle.getText();
			System.out.println("Checking" + text);
			softy.assertTrue(text.contains(brandName));
		}
		softy.assertAll();
	}

}
