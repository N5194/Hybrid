package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class RayBanSearchPage {

	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	public WebElement searchBar;

	public RayBanSearchPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

	public void searchOnRayBanProduect() {
		KeywordsDemo.getDriver()
				.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("rayban", Keys.ENTER);
	}

	public void clickOnGender() throws InterruptedException {
		Thread.sleep(3000);
		KeywordsDemo.getDriver().findElement(By.cssSelector("ul.gender-list>li>label:nth-of-type(1)")).click();
	}

	public void enterProductToSerach(CharSequence... productName) {
		searchBar.sendKeys(productName);
	}
	

}
