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
import com.Pages.HnMResultPage;
import com.Pages.SearchHnMProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HnMproducts_Steps {
	SearchHnMProductPage searchPage = new SearchHnMProductPage();
	HnMResultPage resultPage = new HnMResultPage();

	@Given("User is on the H&M Product Page")
	public void openMyntraWebsite() {
	}

	@When("User enters H&M in the search box and presses ENTER")
	public void userEntersInSearchBoxAndPresses() {
		searchPage.enterProductToSerach("H&M", Keys.ENTER);
	}

	@Then("Search results for {string} are displayed")
	public void searchResultsForAreDisplayed(String expectedProduct) {
		resultPage.verifyProductTitles(expectedProduct);
	}

}
