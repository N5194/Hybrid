package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;


public class HeadphoneResultPage {

	@FindBy(css = "span[class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]")
	WebElement headphone;
	public void showCartProduct() {
		headphone=KeywordsDemo.getDriver().findElement(By.cssSelector("span[data-reactid=\"905\"]"));
		headphone.click();
		List<WebElement> list = KeywordsDemo.getDriver().findElements(By.cssSelector("a[class=\"itemContainer-base-itemLink\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitles : list) {
			String text = productTitles.getText();
			System.out.println("Checking" + text);
			softly.assertTrue(
					text.contains("Buds Aero Truly Wireless Earbuds with 45hrs Playtime and 13mm Driver"));
		}
		softly.assertAll();
	}

	

	public HeadphoneResultPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

}
