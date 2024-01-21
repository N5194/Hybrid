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
import com.Pages.LinkToInstagram_Page;
import com.Pages.VerifyInstagram_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyInstaLinkOnMyntra_Steps {
	private LinkToInstagram_Page linkPage = new LinkToInstagram_Page();
	private VerifyInstagram_Page verifyPage = new VerifyInstagram_Page();
	private String instagramPageTitle;

	@Given("User is on the Myntra homepage")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
		KeywordsDemo.getDriver().executeScript("window.scrollBy(0,2800)");
	}

	@When("User clicks on the Instagram link")
	public void userClicksOnInstagramLink() {
		linkPage.clickInstagramLink();
		verifyPage.switchToInstagramPage();
		instagramPageTitle = verifyPage.getInstagramPageTitle();
	}

	@Then("Instagram page is displayed with the title containing {string}")
	public void instagramPageIsDisplayedWithTitleContaining(String expectedTitle) {
		System.out.println(instagramPageTitle);
		Assert.assertTrue(verifyPage.isInstagramPageTitleContaining(expectedTitle),
				"Expected title contains '" + expectedTitle + "'");
	}
}
