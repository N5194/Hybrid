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
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;
import com.Pages.Mango_Result_Page;
import com.Pages.Search_Mango_Product_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MangoBrandProductSearch_Steps {

	Search_Mango_Product_Page mango = new Search_Mango_Product_Page();

	@Given("the user is on the Mango product search page")
	public void userIsOnMangoProductSearchPage() {
	}

	@When("the user enters MANGO and presses ENTER")
	public void userEntersAndPressesEnter() {
		mango.enterTextToSearch("MANGO", Keys.ENTER);
	}

	@Then("the user should see product titles containing {string}")
	public void userShouldSeeProductTitlesContaining(String expectedText) {
		Mango_Result_Page m = new Mango_Result_Page();
		m.verifyMangoproductTitlesContains(expectedText);
	}

}
