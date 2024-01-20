package com.Stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyNavigation_Steps {

    @Given("the user on the Myntra website")
	public void userIsOnMyntraWebsite() {
		KeywordsDemo keywords = new KeywordsDemo();
		keywords.openBrowser("Chrome");
		keywords.openUrl("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
	}
    @When("the user hovers over the {string} link")
    public void the_user_hovers_over_the_link(String linkText) {
        WebElement link = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-group=\"" + linkText.toLowerCase() + "\"]"));
        Actions actions = new Actions(KeywordsDemo.getDriver());
        actions.moveToElement(link).perform();
    }

    @Then("the {string} link should be displayed")
    public void the_link_should_be_displayed(String linkText) {
        WebElement link = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-group=\"" + linkText.toLowerCase() + "\"]"));
        Assert.assertTrue(link.isDisplayed(), linkText + " link is not displayed");
    }

}
