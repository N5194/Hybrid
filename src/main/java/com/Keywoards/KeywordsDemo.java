package com.Keywoards;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Error.InvalidBrowserError;
import com.exception.InvalidSelectorException;

public class KeywordsDemo {

	private static RemoteWebDriver driver;

	/**
	 * This method will launch specific browser.
	 * 
	 * @param browserName
	 */
	
	/**
	 * This method return the driver instance. Make sure,before calling this one
	 * should call {@code open browser(String browserName)} method so that it can
	 * initialize driver instance
	 * 
	 * @return driver instance
	 */
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Opening ChromeDriver");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Opening FirefoxDriver");
		} else {
			System.out.println("invalid browser name");
			throw new InvalidBrowserError(browserName);
		}
	}


	/**
	 * this method will open specific url
	 * 
	 * @param url
	 */
	public void openUrl(String url) {
		driver.get(url);
		System.out.println("Launching URL");
	}

	/**
	 * this method will close the specific browser.
	 * 
	 */
	public void closeDriver() {
		driver.close();
	}

	public void clickOn(WebElement weblement) {
		weblement.click();
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}

	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void enterText(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public void enterText(String Locator, String text) {
		String LocatorType = Locator.split("##")[0];
		String LocatorValue = Locator.split("##")[1];
		enterText(LocatorType, LocatorValue, text);
	}

	public void hitKey(int keyCode) {
		try {
			Robot r = new Robot();
			r.keyPress(keyCode);
			r.keyRelease(keyCode);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public List<String> getText(String locatorType, String locatorValue) {
		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = getWebElements(locatorType, locatorValue);
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	public List getText(String locator) {
		String LocatorType = locator.split("##")[0];
		String LocatorValue = locator.split("##")[1];
		return getText(LocatorType, LocatorValue);

	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void quitAllWindows() {
		driver.quit();
	}

	public List<String> getText(List<WebElement> items) {
		List<String> texts = new ArrayList<String>();
		for (WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;
	}

}
