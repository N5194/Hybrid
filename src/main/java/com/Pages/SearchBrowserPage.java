package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;


public class SearchBrowserPage {

	@FindBy(css = "input[class='desktop-searchBar']")
	private WebElement searchInput;
	
	
	public void enterProductToSerach() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("input[class='desktop-searchBar']"))
				.sendKeys("Running shoes",Keys.ENTER);
	}

	public void productImage() {
		KeywordsDemo.getDriver().findElement(By.cssSelector("img[class=\"img-responsive\"]"));
	}

	public SearchBrowserPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

}
