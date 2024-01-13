package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;


public class SearchHnMProductPage {

	
	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	public WebElement searchHnM;

	public SearchHnMProductPage() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);
	}

	public void enterProductToSerach(CharSequence... productName) {
		searchHnM.sendKeys(productName);
	}

}
