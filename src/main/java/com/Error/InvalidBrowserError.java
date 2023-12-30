package com.Error;

public class InvalidBrowserError extends Error {
	String browser;

	@Override
	public String getMessage() {
		return "Invalid Error" + browser;
	}

	public InvalidBrowserError(String browser) {
		this.browser = browser;
	}

}
