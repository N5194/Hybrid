package com.Stepdefinations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductAddToWishlist_Steps {

	@Given("User opens Myntra website")
	public void userOpensMyntraWebsite() {
	}

	@When("User hovers over the navigation menu")
	public void user_hovers_over_the_navigation_menu() {
		Actions actions = new Actions(KeywordsDemo.getDriver());
		WebElement navigationMenu = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-reactid=\"676\"]"));
		actions.moveToElement(navigationMenu).perform();
	}

	@When("User clicks on the wish list option")
	public void user_clicks_on_the_wish_list_option() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-reactid=\"747\"]")).click();
	}

	@When("User clicks on a product")
	public void user_clicks_on_a_product() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("h4[class=\"product-product\"]")).click();
	}

	@Then("User adds the product to the wish list")
    public void user_adds_the_product_to_the_wish_list() {
    	String parenthandles = KeywordsDemo.getDriver().getWindowHandle();
        Set<String> handles = KeywordsDemo.getDriver().getWindowHandles();
        handles.remove(parenthandles);

        for (String handle : handles) {
        	KeywordsDemo.getDriver().switchTo().window(handle);
        	KeywordsDemo.getDriver().executeScript("window.scrollBy(0,200)");
        	KeywordsDemo.getDriver().findElement(By.cssSelector("span[class=\"myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center \"]")).click();
        	Assert.assertTrue(KeywordsDemo.getDriver().findElement(By.cssSelector("your-wishlist-selector")).isDisplayed());
        	KeywordsDemo.getDriver().quit();
        }
    }

}
