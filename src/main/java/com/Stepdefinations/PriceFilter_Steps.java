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
import com.Pages.RayBanFilterResultPage;
import com.Pages.RayBanSearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceFilter_Steps {

    RayBanSearchPage page = new RayBanSearchPage();
    RayBanFilterResultPage result = new RayBanFilterResultPage();
    
    @Given("user is on the RayBan search page")
    public void userIsOnRayBanSearchPage() {
    }
    @When("user enters {string} and hits Enter")
    public void userEntersProductNameAndHitsEnter(String productName) {
        page.enterProductToSerach(productName, Keys.ENTER);
    }

    @When("user clicks on the gender filter")
    public void userClicksOnGenderFilter() throws InterruptedException {
        page.clickOnGender();
    }

    @When("user clicks on the price filter")
    public void userClicksOnPriceFilter() {
        result.clickOnPriceFilter();
    }

    @Then("user should see filtered results")
    public void userShouldSeeFilteredResults(String brand ) {
		FluentWait<RemoteWebDriver> wait = new FluentWait<>(KeywordsDemo.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h4[class=\"product-product\"]"), 1));

		List<WebElement> productList = KeywordsDemo.getDriver()
				.findElements(By.cssSelector("h4[class=\"product-product\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitle : productList) {
			String text = productTitle.getText();
			System.out.println("Checking " + text);
			softly.assertTrue(text.contains(brand) && text.contains("Sunglasses"));
		}

		softly.assertAll();
		KeywordsDemo.getDriver().quit();
    }
   
}
