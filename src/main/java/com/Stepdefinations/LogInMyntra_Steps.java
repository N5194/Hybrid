package com.Stepdefinations;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;
import com.Pages.Myntra_Login_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInMyntra_Steps {
	Myntra_Login_Page m = new Myntra_Login_Page();

	@Given("I am on the Myntra login page")
	public void userOpensMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("I click the login button")
	public void iClickLoginButton() {
		m.clickLoginButton();
	}

	@When("I click the sign-up link")
	public void iClickSignUpLink() {
		m.clickSignUpLink();
	}

	@When("I enter my mobile number \"([^\"]*)\"$")
	public void iEnterMobileNumber(String mobileNumber) {
		m.enterMobileNumber(mobileNumber);
	}

	@When("I click the submit button")
	public void iClickSubmitButton() throws InterruptedException {
		m.clickSubmitButton();
	}

	@Then("I should see the result")
	public void iShouldSeeResult() {
		Assert.assertTrue(KeywordsDemo.getDriver().getCurrentUrl().contains("myntra-login-page-url"));
	}
}
