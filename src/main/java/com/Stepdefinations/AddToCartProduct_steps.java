package com.Stepdefinations;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;
import com.Pages.HeadphoneResultPage;
import com.Pages.SearchHeadphonePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartProduct_steps {

	Logger log = Logger.getLogger(AddToCartProduct_steps.class);
	SoftAssert softly = new SoftAssert();
	SearchHeadphonePage searchPage = new SearchHeadphonePage();
	HeadphoneResultPage resultPage = new HeadphoneResultPage();

	@Given("I am on the headphone search page")
	public void userIsOnMyntraWebsite() {
	}

	@When("I enter and search for the product")
	public void iEnterAndSearchForProduct() throws InterruptedException {
		searchPage.enterAndSearchProduct();
		log.info("Enter headphones on search and hit enter key");
	}

	@When("I add the headphone to the cart")
	public void iAddHeadphoneToCart() throws InterruptedException {
		searchPage.addHeadphoneToCart();
	}

	@Then("I should see the product in the cart")
	public void iShouldSeeProductInCart() {
		resultPage.showCartProduct();
	}

}
