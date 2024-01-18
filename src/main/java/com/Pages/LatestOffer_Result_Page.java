package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;

public class LatestOffer_Result_Page {
	@FindBy(css = "span[class=\"iz-news-hub-notification-title iz-news-hub-text-body iz-news-hub-black-color iz-news-hub-line-clamp iz-news-hub-line-clamp-4\"]")
	WebElement offerlist;

	public void getOfferList() {
		List<WebElement> OfferList = KeywordsDemo.getDriver().findElements(By.cssSelector(
				"span[class=\"iz-news-hub-notification-title iz-news-hub-text-body iz-news-hub-black-color iz-news-hub-line-clamp iz-news-hub-line-clamp-4\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement list : OfferList) {
			String text = list.getText();
			System.out.println("Checking" + text);
			softly.assertTrue(!text.isEmpty(), "Offer text is empty for: " + text);
		}

		softly.assertAll();
	}

//	public List<WebElement> getOfferList() {
//		return KeywordsDemo.getDriver().findElements(By.cssSelector(
//				"span[class=\"iz-news-hub-notification-title iz-news-hub-text-body iz-news-hub-black-color iz-news-hub-line-clamp iz-news-hub-line-clamp-4\"]"));
//	}

	public LatestOffer_Result_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}

}
