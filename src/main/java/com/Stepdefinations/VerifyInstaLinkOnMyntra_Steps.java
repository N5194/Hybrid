package com.Stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyInstaLinkOnMyntra_Steps {

	@Given("the user is open the Myntra website")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("the user scrolls down the page")
	public void the_user_scrolls_down_the_page() {
		KeywordsDemo.getDriver().executeScript("window.scrollBy(0,2800)");
	}

	@When("clicks on the Instagram link")
	public void clicks_on_the_instagram_link() {
		KeywordsDemo.getDriver().findElement(By.cssSelector(
				"img[src=\"https://constant.myntassets.com/web/assets/img/b4fcca19-5fc1-4199-93ca-4cae3210ef7f1574604275408-insta.png\"]"))
				.click();
	}

	@When("switches to the Instagram login page")
	public void switches_to_the_instagram_login_page() {
		FluentWait<RemoteWebDriver> wait = new FluentWait<>(KeywordsDemo.getDriver());
		wait.pollingEvery(Duration.ofMillis(2000));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"_abn5 _abn6 _aa5h\"]")))
				.click();
	}

	@Then("the user should see the Instagram page with the title containing {string}")
	public void the_user_should_see_the_instagram_page_with_the_title_containing(String expectedTitle) {
        String instagramPageTitle = KeywordsDemo.getDriver().getTitle();
        System.out.println(instagramPageTitle);
        Assert.assertTrue(instagramPageTitle.contains(expectedTitle), "Expected title contains '" + expectedTitle + "'");
        KeywordsDemo.getDriver().quit();

	}
}
