package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class VerifyInstagram_Page {
	
	WebElement w;
	public void switchToInstagramPage() {
		KeywordsDemo.getDriver().get("https://www.instagram.com/myntra/");
	}

	public String getInstagramPageTitle() {
		return KeywordsDemo.getDriver().getTitle();
	}

	public boolean isInstagramPageTitleContaining(String expectedTitlePart) {
		String actualTitle = getInstagramPageTitle();
		return actualTitle.contains(expectedTitlePart);
	}

	public VerifyInstagram_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}
	
	
}
