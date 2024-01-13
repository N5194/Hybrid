package com.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;


public class SearchHeadphonePage {

	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	WebElement headphone;
	By enterProduct = By.cssSelector("input[placeholder=\"Search for products, brands and more\"]");

	public void enterAndSearchProduct() throws InterruptedException {
		headphone = KeywordsDemo.getDriver().findElement(By.cssSelector(
				"input[placeholder=\"Search for products, brands and more\"]"));
		headphone.sendKeys("headphones", Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void addHeadphoneToCart() throws InterruptedException {
		headphone=KeywordsDemo.getDriver().findElement(By.cssSelector(
				"img[src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/23241662/2023/5/25/843e98b5-c506-49fc-bc35-71c804a4f7eb1684989775452-NOISE-Unisex-Headphones-3141684989775112-1.jpg\"]"));
				headphone.click();

		String parentHandle = KeywordsDemo.getDriver().getWindowHandle();
		Set<String> handles = KeywordsDemo.getDriver().getWindowHandles();
		handles.remove(parentHandle);
		for (String handle : handles) {
			KeywordsDemo.getDriver().switchTo().window(handle);
			KeywordsDemo.getDriver().executeScript("window.scrollBy(0,400)");
			KeywordsDemo.getDriver().findElement(By
					.cssSelector("span[class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]"))
					.click();
			Thread.sleep(3000);
		}

	}

	public SearchHeadphonePage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

}
