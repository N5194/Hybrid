package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keywoards.KeywordsDemo;

public class Myntra_Login_Page {
	@FindBy(css = "span[data-reactid=\"856\"]")
	
	public WebElement myntralogin;
	
	private By loginButton = By.cssSelector("span[data-reactid=\"856\"]");
	private By signUpLink = By.cssSelector("a[data-reactid=\"865\"]");
	private By mobileNumberInput = By.cssSelector("input[class=\"form-control mobileNumberInput\"]");
	private By submitButton = By.cssSelector("[class=\"submitBottomOption\"]");

	public void clickLoginButton() {
		KeywordsDemo.getDriver().findElement(loginButton).click();
	}

	public void clickSignUpLink() {
		KeywordsDemo.getDriver().findElement(signUpLink).click();
	}

	public void enterMobileNumber(String mobileNumber) {
		KeywordsDemo.getDriver().findElement(mobileNumberInput).sendKeys(mobileNumber);
	}

	public void clickSubmitButton() throws InterruptedException {
		Thread.sleep(2000);
		KeywordsDemo.getDriver().findElement(submitButton).click();
	}

	public Myntra_Login_Page() {
		PageFactory.initElements(KeywordsDemo.getDriver(), this);

	}

}
