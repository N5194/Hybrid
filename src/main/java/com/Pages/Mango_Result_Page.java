package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Keywoards.KeywordsDemo;
import com.exception.InvalidSelectorException;
import com.waits.WaitsDemo;

public class Mango_Result_Page {
	@FindBy(css = "h3[class=\"product-brand\"]")
	List<WebElement> managoProducts;

	By managoProduct = By.cssSelector("h3[class=\"product-brand\"]");

	public List<String> getManagoProducts() throws InvalidSelectorException {
		WaitsDemo.numberOfElementsToBeMoreThan(managoProduct, 1);
		KeywordsDemo keyword = new KeywordsDemo();
		return keyword.getText(managoProducts);
	}

	public void verifyMangoproductTitlesContains(String expectedText) throws InvalidSelectorException {
		List<String> newList = getManagoProducts();
		SoftAssert softy = new SoftAssert();
		for (String Tiltes : newList) {
			System.out.println("Checking" + Tiltes);
			softy.assertTrue(Tiltes.contains(expectedText));
		}
		softy.assertAll();
	}

	public Mango_Result_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}

}
