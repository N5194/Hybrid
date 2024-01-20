package com.Stepdefinations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Base.Config;
import com.Keywoards.KeywordsDemo;

public class Hooks {

	KeywordsDemo keyword = new KeywordsDemo();

	@BeforeMethod
	public void setUp() {
		keyword.openBrowser("Chrome");
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());

	}

	@AfterMethod
	public void tearDown() {
		keyword.quitAllWindows();
	}

}
