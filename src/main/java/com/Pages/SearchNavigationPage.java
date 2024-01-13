package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Keywoards.KeywordsDemo;

public class SearchNavigationPage {

	@FindBy(css = "a[data-group=\"men\"]")
	public WebElement navigation;

	public void navigateToMen() throws InterruptedException {
		Actions ac = new Actions(KeywordsDemo.getDriver());
		WebElement men = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-group=\"men\"]"));
		ac.moveToElement(men).perform();
		Thread.sleep(2000);
		Assert.assertTrue(men.isDisplayed(), "Men link is not displayed");
	}
	
	public void navigateToWomen() throws InterruptedException {
		Actions ac1 = new Actions(KeywordsDemo.getDriver());
		WebElement women = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-group=\"women\"]"));
		ac1.moveToElement(women).perform();
		Thread.sleep(2000);
		Assert.assertTrue(women.isDisplayed(), "Women link is not displayed");

	}
	
	public void navigateToKids() throws InterruptedException {
		Actions ac1 = new Actions(KeywordsDemo.getDriver());
		WebElement women = KeywordsDemo.getDriver().findElement(By.cssSelector("a[data-group=\"kids\"]"));
		ac1.moveToElement(women).perform();
		Thread.sleep(2000);
		Assert.assertTrue(women.isDisplayed(), "Kids link is not displayed");

	}

	public SearchNavigationPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}

}
