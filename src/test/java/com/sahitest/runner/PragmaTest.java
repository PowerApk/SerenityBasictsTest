package com.sahitest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "resources/features/pragma_test.feature",
		glue = "com.sahitest.stepdefinitions",
		snippets = SnippetType.CAMELCASE
		)
public class PragmaTest {

}
