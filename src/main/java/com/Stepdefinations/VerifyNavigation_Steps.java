package com.Stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;
import com.Pages.SearchNavigationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyNavigation_Steps {
	private SearchNavigationPage searchNavigationPage = new SearchNavigationPage();

	@Given("User is on the search navigation page")
	public void userIsOnMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("User navigates to Men section")
	public void userNavigatesToMenSection() throws InterruptedException {
		searchNavigationPage.navigateToMen();
	}

	@When("User navigates to Women section")
	public void userNavigatesToWomenSection() throws InterruptedException {
		searchNavigationPage.navigateToWomen();
	}

	@When("User navigates to Kids section")
	public void userNavigatesToKidsSection() throws InterruptedException {
		searchNavigationPage.navigateToKids();
	}

	@Then("User has successfully navigated through Men, Women, and Kids sections")
	public void userSuccessfullyNavigatedThroughSections() {

	}

}
