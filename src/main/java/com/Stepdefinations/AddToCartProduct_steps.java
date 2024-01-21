package com.Stepdefinations;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;
import com.Pages.HeadphoneResultPage;
import com.Pages.SearchHeadphonePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartProduct_steps {
	SoftAssert softly = new SoftAssert();
	SearchHeadphonePage searchPage = new SearchHeadphonePage();
	HeadphoneResultPage resultPage = new HeadphoneResultPage();

	@Given("I am on the headphone search page")
	public void userIsOnMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		keywords.getDriver().manage().window().maximize();
	}

	@When("I enter and search for the product")
	public void iEnterAndSearchForProduct() throws InterruptedException {
		searchPage.enterAndSearchProduct();
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
