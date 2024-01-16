package com.Pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class WishList_Page {
	@FindBy(css = "a[data-reactid=\"676\"]")
	WebElement wishlist;

	public void hoverOverMenu() {
		Actions actions = new Actions(KeywordsDemo.getDriver());
		WebElement menu = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-reactid=\"676\"]"));
		actions.moveToElement(menu).perform();
	}

	public void clickWishlist() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-reactid=\"747\"]")).click();
	}

	public void clickProduct() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("h4[class=\"product-product\"]")).click();
	}

	public void switchToNewWindow() {
		String parentHandle = KeywordsDemo.getDriver().getWindowHandle();
		for (String handle : KeywordsDemo.getDriver().getWindowHandles()) {
			if (!handle.equals(parentHandle)) {
				KeywordsDemo.getDriver().switchTo().window(handle);
			}
		}
	}

	public void addToWishlist() {
		KeywordsDemo.getDriver().executeScript("window.scrollBy(0,200)");
		KeywordsDemo.getDriver().findElement(By.cssSelector(
				"span[class=\"myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center \"]"))
				.click();
	}

	public WishList_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}

}
