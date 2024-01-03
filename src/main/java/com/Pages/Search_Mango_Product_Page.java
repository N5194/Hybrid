package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class Search_Mango_Product_Page {
	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	public WebElement mangoproduct;

	public void enterTextToSearch(CharSequence... textname) {
		mangoproduct.sendKeys(textname);

	}

	public Search_Mango_Product_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}
}
