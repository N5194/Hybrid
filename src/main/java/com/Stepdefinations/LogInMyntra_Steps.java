package com.Stepdefinations;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInMyntra_Steps {

	@Given("User opens the Myntra website to LogIn")
	public void userOpensMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("span[data-reactid=\"856\"]")).click();
	}

	@When("User clicks on the login via OTP option")
	public void user_clicks_on_the_login_via_otp_option() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-reactid=\"865\"]")).click();
	}

	@When("User enters the mobile number {string}")
	public void user_enters_the_mobile_number(String string) {
		KeywordsDemo.getDriver().findElement(By.cssSelector("input[class=\"form-control mobileNumberInput\"]"))
				.sendKeys("9156485884");
	}

	@When("User clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("[class=\"submitBottomOption\"]")).click();
	}

	@Then("User should be on the Myntra login page")
	public void user_should_be_on_the_myntra_login_page() {
		Assert.assertTrue(KeywordsDemo.getDriver().getCurrentUrl().contains("myntra-login-page-url"));
	}

}
