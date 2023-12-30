package com.exception;

public class InvalidSelectorException extends RuntimeException {

	String locatorType;

	public InvalidSelectorException(String locatorType) {
	super();
	this.locatorType = locatorType;
}
	@Override
	public String getMessage() {
		return "Invalid Locator Type"+ locatorType;
	}

}
