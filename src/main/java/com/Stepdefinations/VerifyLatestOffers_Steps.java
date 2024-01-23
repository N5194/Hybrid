package com.Stepdefinations;

import com.Keywoards.KeywordsDemo;
import com.Pages.LatestOffer_Page;
import com.Pages.LatestOffer_Result_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyLatestOffers_Steps {
	private LatestOffer_Page latestOfferPage = new LatestOffer_Page();
	private LatestOffer_Result_Page latestOfferResultPage = new LatestOffer_Result_Page();

	@Given("User is on the Myntra homepage now")
	public void openMyntraWebsite() {
	}

	@When("User clicks on the Myntra logo")
	public void userClicksOnMyntraLogo() {
		latestOfferPage.clickMyntraLogo();
	}

	@When("User scrolls down {int} pixels")
	public void userScrollsDownPixels(int pixels) {
		latestOfferPage.scrollDown(pixels);
	}

	@Then("User checks the latest offers list")
	public void userChecksLatestOffersList() {
		latestOfferResultPage.getOfferList();
	}

}
