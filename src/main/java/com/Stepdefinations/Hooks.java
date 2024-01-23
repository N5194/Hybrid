package com.Stepdefinations;


import com.Base.Config;
import com.Keywoards.KeywordsDemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	KeywordsDemo keyword = new KeywordsDemo();

	@Before
	public void setUp() {
		keyword.openBrowser("Chrome");
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());

	}

	@After
	public void tearDown() {
		keyword.quitAllWindows();
	}

}
