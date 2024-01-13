package com.testcases;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Base.TestBase;
import com.Pages.HeadphoneResultPage;
import com.Pages.HnMResultPage;
import com.Pages.Mango_Result_Page;
import com.Pages.RayBanFilterResultPage;
import com.Pages.RayBanSearchPage;
import com.Pages.SearchHeadphonePage;
import com.Pages.SearchHnMProductPage;
import com.Pages.SearchNavigationPage;
import com.Pages.Search_Mango_Product_Page;
import com.exception.InvalidSelectorException;

public class TestCase {
	@Test
	public void verifyManagoBrandProducts() {

		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("MANGO", Keys.ENTER);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h3[class=\"product-brand\"]"), 1));
		List<WebElement> list = driver.findElements(By.cssSelector("h3[class=\"product-brand\"]"));
		SoftAssert softy = new SoftAssert();

		for (WebElement productTitle : list) {
			String text = productTitle.getText();
			System.out.println("Checking" + text);
			softy.assertTrue(text.contains("MANGO"));
		}
		softy.assertAll();

	}

	@Test
	public void verifyManagoBrandProductsUsingPage() throws InvalidSelectorException {
		Search_Mango_Product_Page mango = new Search_Mango_Product_Page();
		mango.enterTextToSearch("MANGO", Keys.ENTER);
		Mango_Result_Page m = new Mango_Result_Page();
		m.verifyMangoproductTitlesContains("MANGO");
	}

	@Test
	public void verifyMyntraLoginPage() throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ch.addArguments("--incognito");
		RemoteWebDriver driver = new ChromeDriver(ch);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("span[data-reactid=\"856\"]")).click();
		driver.findElement(By.cssSelector("a[data-reactid=\"865\"]")).click();
		driver.findElement(By.cssSelector("input[class=\"form-control mobileNumberInput\"]")).sendKeys("9156482884");
		driver.findElement(By.cssSelector("div[class=\"submitBottomOption\"]")).click();
	}

	@Test
	public void verifyWishListAddProduct() {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ch.addArguments("--incognito");
		RemoteWebDriver driver = new ChromeDriver(ch);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement b = driver.findElement(By.cssSelector("a[data-reactid=\"676\"]"));
		a.moveToElement(b).perform();
		driver.findElement(By.cssSelector("a[data-reactid=\"747\"]")).click();
		driver.findElement(By.cssSelector("h4[class=\"product-product\"]")).click();
		String parenthandles = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(parenthandles);

		for (String handle : handles) {
			driver.switchTo().window(handle);
			driver.executeScript("window.scrollBy(0,200)");
			driver.findElement(By.cssSelector("span[class=\"myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center \"]")).click();

		}
	}

	@Test
	public void verifyHnMProducts() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("H&M", Keys.ENTER);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h3[class=\"product-brand\"]"), 1));
		List<WebElement> list = driver.findElements(By.cssSelector("h3[class=\"product-brand\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitles : list) {
			String text = productTitles.getText();
			System.out.println("Checking" + text);
			softly.assertTrue(text.contains("H&M"));
		}
		softly.assertAll();
		driver.close();
	}

	@Test
	public void verifySearchHnMUsingPageObjectModel() {
		SearchHnMProductPage page = new SearchHnMProductPage();
		page.enterProductToSerach("H&M", Keys.ENTER);
		HnMResultPage result = new HnMResultPage();
		result.verifyProductTitles("H&M");
	}

	@Test
	public void verifyAddToCartHeadphone() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("headphones", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(
				"img[src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/23241662/2023/5/25/843e98b5-c506-49fc-bc35-71c804a4f7eb1684989775452-NOISE-Unisex-Headphones-3141684989775112-1.jpg\"]"))
				.click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(parentHandle);
		for (String handle : handles) {
			driver.switchTo().window(handle);
			driver.executeScript("window.scrollBy(0,400)");
			driver.findElement(By
					.cssSelector("span[class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("span[data-reactid=\"905\"]")).click();
			List<WebElement> list = driver.findElements(By.cssSelector("a[class=\"itemContainer-base-itemLink\"]"));
			SoftAssert softly = new SoftAssert();

			for (WebElement productTitles : list) {
				String text = productTitles.getText();
				System.out.println("Checking" + text);
				softly.assertTrue(
						text.contains("Buds Aero Truly Wireless Earbuds with 45hrs Playtime and 13mm Driver"));
			}
			softly.assertAll();
		}
	}

	@Test
	public void verifyAddHeadphoneToCart() throws InterruptedException {
		SearchHeadphonePage page = new SearchHeadphonePage();
		page.enterAndSearchProduct();
		page.addHeadphoneToCart();
		HeadphoneResultPage result = new HeadphoneResultPage();
		result.showCartProduct();
	}

	@Test
	public void verifyPriceFilter() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("rayban", Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("1");
		driver.findElement(By.cssSelector("ul.gender-list>li>label:nth-of-type(1)")).click();
		System.out.println("2");
		driver.findElement(By.cssSelector("ul.price-list>li:nth-of-type(1)")).click();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h4[class=\"product-product\"]"), 1));

		List<WebElement> list = driver.findElements(By.cssSelector("h4[class=\"product-product\"]"));
		SoftAssert softly = new SoftAssert();

		for (WebElement productTitles : list) {
			String text = productTitles.getText();
			System.out.println("Checking" + text);
			softly.assertTrue(text.contains("Sunglasses"));
		}
		softly.assertAll();
	}

	@Test
	public void verifyProductFilter() throws InterruptedException {
		RayBanSearchPage page = new RayBanSearchPage();
		page.enterProductToSerach("rayban", Keys.ENTER);
		page.clickOnGender();
		RayBanFilterResultPage result = new RayBanFilterResultPage();
		result.clickOnPriceFilter();
	}

	@Test
	public void verifyNavigation() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Actions ac = new Actions(driver);
		WebElement men = driver.findElement(By.cssSelector("a[data-group=\"men\"]"));
		ac.moveToElement(men).perform();
		Thread.sleep(2000);
		Assert.assertTrue(men.isDisplayed(), "Men link is not displayed");

		Actions ac1 = new Actions(driver);
		WebElement women = driver.findElement(By.cssSelector("a[data-group=\"women\"]"));
		ac1.moveToElement(women).perform();
		Thread.sleep(2000);
		Assert.assertTrue(women.isDisplayed(), "Women link is not displayed");

		Actions ac2 = new Actions(driver);
		WebElement kids = driver.findElement(By.cssSelector("a[data-group=\"kids\"]"));
		ac2.moveToElement(kids).perform();
		Thread.sleep(2000);
		Assert.assertTrue(kids.isDisplayed(), "Kids link is not displayed");

	}

	@Test
	public void verifyTagNavigation() throws InterruptedException {
		SearchNavigationPage page = new SearchNavigationPage();
		page.navigateToMen();
		page.navigateToWomen();
		page.navigateToKids();
	}

}
