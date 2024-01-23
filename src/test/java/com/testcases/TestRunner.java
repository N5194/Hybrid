package com.testcases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com.Stepdefinations", plugin = {
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
