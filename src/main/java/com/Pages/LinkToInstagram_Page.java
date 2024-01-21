package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class LinkToInstagram_Page {
	@FindBy(css = "img[src=\"https://constant.myntassets.com/web/assets/img/b4fcca19-5fc1-4199-93ca-4cae3210ef7f1574604275408-insta.png\"]")
	WebElement instagram;

	public void openMyntraHomePage() {
		KeywordsDemo.getDriver().get("https://www.myntra.com/");
		KeywordsDemo.getDriver().manage().window().maximize();
		KeywordsDemo.getDriver().executeScript("window.scrollBy(0,2800)");
	}

	public void clickInstagramLink() {
		KeywordsDemo.getDriver().findElement(By.cssSelector(
				"img[src=\"https://constant.myntassets.com/web/assets/img/b4fcca19-5fc1-4199-93ca-4cae3210ef7f1574604275408-insta.png\"]"))
				.click();

	}

	public LinkToInstagram_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

}
