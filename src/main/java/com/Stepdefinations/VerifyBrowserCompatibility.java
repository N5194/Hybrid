package com.Stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;
import com.Pages.SearchBrowserPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyBrowserCompatibility {
	SearchBrowserPage page = new SearchBrowserPage();

	@Given("User opens the search browser page")
	public void openMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("User enters the product to search")
	public void userEntersProductToSearch() {
		page.enterProductToSerach();
	}

	@Then("Search results are displayed")
	public void searchResultsDisplayed() {
		System.out.println("Search results are displayed");
	}

}
