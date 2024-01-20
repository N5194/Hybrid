package com.Stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyBrowserCompatibility {

	@Given("user open myntra website")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("the user searches for {string}")
	public void the_user_searches_for(String product) {
		KeywordsDemo.getDriver().findElement(By.cssSelector("input[class=\"desktop-searchBar\"]")).sendKeys(product,
				Keys.ENTER);

	}

	@Then("the user should see product items displayed")
	public void the_user_should_see_product_items_displayed() {
		Assert.assertTrue(
				KeywordsDemo.getDriver().findElement(By.cssSelector("img[class=\"img-responsive\"]")).isDisplayed(),
				"Product items are not displayed");
		KeywordsDemo.getDriver().quit();
	}

}
