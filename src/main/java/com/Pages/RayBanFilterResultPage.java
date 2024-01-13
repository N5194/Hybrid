package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;


public class RayBanFilterResultPage {

	@FindBy(css = "label[class=\"common-customRadio gender-label\"]")
	public WebElement raybanFilter;

	private By filter = By.cssSelector("label[class=\"common-customRadio gender-label\"]");


	public RayBanFilterResultPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

	public void clickOnPriceFilter() {
		KeywordsDemo.getDriver()
		.findElement(By.cssSelector("ul.price-list>li:nth-of-type(1)")).click();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(KeywordsDemo.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h4[class=\"product-product\"]"), 1));

		List<WebElement> list = KeywordsDemo.getDriver().findElements(By.cssSelector("h4[class=\"product-product\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitles : list) {
			String text = productTitles.getText();
			System.out.println("Checking" + text);
			softly.assertTrue(text.contains("Sunglasses"));
		}
		softly.assertAll();

	}
}
