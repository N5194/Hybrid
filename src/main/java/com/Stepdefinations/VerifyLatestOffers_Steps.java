package com.Stepdefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyLatestOffers_Steps {

	@Given("user on the Myntra website")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("the user clicks on the Myntra logo")
	public void the_user_clicks_on_the_myntra_logo() {
		KeywordsDemo.getDriver()
				.findElement(By.cssSelector("a[class=\"myntraweb-sprite desktop-logo sprites-headerLogo \"]")).click();
	}

	@When("scrolls down the page")
	public void scrolls_down_the_page() {
		KeywordsDemo.getDriver().executeScript("window.scrollBy(0,500)");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("clicks on the subscribe icon for latest offers")
	public void clicks_on_the_subscribe_icon_for_latest_offers() {
		KeywordsDemo.getDriver().findElement(By.cssSelector(
				"div[class=\"iz-news-hub-floating-icon-container iz-news-hub-floating-icon-container-bottom-right iz-news-hub-subscribe\"]"))
				.click();
	}

	@Then("the user should see non-empty latest offers")
	public void the_user_should_see_non_empty_latest_offers() {
		List<WebElement> offerList = KeywordsDemo.getDriver().findElements(By.cssSelector(
				"span[class=\"iz-news-hub-notification-title iz-news-hub-text-body iz-news-hub-black-color iz-news-hub-line-clamp iz-news-hub-line-clamp-4\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement offer : offerList) {
			String text = offer.getText();
			System.out.println("Checking " + text);
			softly.assertTrue(!text.isEmpty(), "Offer text is empty for: " + text);
		}

		softly.assertAll();
		KeywordsDemo.getDriver().quit();
	}

}
