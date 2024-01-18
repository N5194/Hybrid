package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class LatestOffer_Page {
	@FindBy(css = "a[class=\"myntraweb-sprite desktop-logo sprites-headerLogo \"]")
	WebElement offers;

	public void clickMyntraLogo() {
		KeywordsDemo.getDriver()
				.findElement(By.cssSelector("a[class=\"myntraweb-sprite desktop-logo sprites-headerLogo \"]")).click();
	}

	public void scrollDown(int pixels) {
		KeywordsDemo.getDriver().executeScript("window.scrollBy(0," + pixels + ")");
	}

	public void clickSubscribeIcon() {
		KeywordsDemo.getDriver().findElement(By.cssSelector(
				"div[class=\"iz-news-hub-floating-icon-container iz-news-hub-floating-icon-container-bottom-right iz-news-hub-subscribe\"]"))
				.click();
	}

	public LatestOffer_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}

}
