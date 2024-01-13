package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;
import com.waits.HnMWaits;


public class HnMResultPage {

	@FindBy(css = "h3[class=\"product-brand\"]")
	public List<WebElement> hnMTitles;

	private By hnMTitle = By.cssSelector("h3[class=\"product-brand\"]");

	public List<String> getHnMTitles() {
		HnMWaits.numberOfElementsToBeMoreThan(hnMTitle, 1);
		KeywordsDemo keyword = new KeywordsDemo();
		return keyword.getText(hnMTitles);
	}

	public HnMResultPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

	public void verifyProductTitles(String expectedText) {
		List<String> titles = getHnMTitles();
		SoftAssert softly = new SoftAssert();
		for (String title : titles) {
			System.out.println("checking" + title);

			softly.assertTrue(title.contains(expectedText));
		}
		softly.assertAll();

	}

	
}
