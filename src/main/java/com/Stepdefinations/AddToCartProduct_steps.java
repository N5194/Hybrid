package com.Stepdefinations;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartProduct_steps {
	SoftAssert softly = new SoftAssert();

	@Given("User is on the Myntra website")
	public void userIsOnMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		keywords.getDriver().manage().window().maximize();
	}

	@When("User searches for {string}")
	public void user_searches_for(String searchTerm) throws InterruptedException {
		KeywordsDemo.getDriver()
				.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys(searchTerm, Keys.ENTER);
		Thread.sleep(3000);
	}

	@When("User clicks on a specific headphone")
	public void user_clicks_on_a_specific_headphone() {
		KeywordsDemo.getDriver().findElement(By.cssSelector(
				"img[src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/23241662/2023/5/25/843e98b5-c506-49fc-bc35-71c804a4f7eb1684989775452-NOISE-Unisex-Headphones-3141684989775112-1.jpg\"]"))
				.click();

		String parentHandle = KeywordsDemo.getDriver().getWindowHandle();
		Set<String> handles = KeywordsDemo.getDriver().getWindowHandles();
		handles.remove(parentHandle);
		for (String handle : handles) {
			KeywordsDemo.getDriver().switchTo().window(handle);
			KeywordsDemo.getDriver().executeScript("window.scrollBy(0,400)");
		}
	}

	@When("User adds the headphone to the cart")
	public void user_adds_the_headphone_to_the_cart() throws InterruptedException {
		KeywordsDemo.getDriver().findElement(
				By.cssSelector("span[class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]"))
				.click();
		Thread.sleep(3000);
		KeywordsDemo.getDriver().findElement(By.cssSelector("span[data-reactid=\"905\"]")).click();
	}

	@When("User goes to the cart and verifies the added product")
	public void user_goes_to_the_cart_and_verifies_the_added_product() {
		List<WebElement> list = KeywordsDemo.getDriver()
				.findElements(By.cssSelector("a[class=\"itemContainer-base-itemLink\"]"));

		for (WebElement productTitles : list) {
			String text = productTitles.getText();
			System.out.println("Checking" + text);
			softly.assertTrue(text.contains("Buds Aero Truly Wireless Earbuds with 45hrs Playtime and 13mm Driver"));
		}
		softly.assertAll();
	}

	@Then("User closes the browser")
	public void user_closes_the_browser() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.quitAllWindows();

	}

}
