package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(snippets =SnippetType.CAMELCASE,strict = true, dryRun = false,plugin = {"pretty","json:target/cucumber.json"}, monochrome = true, features = "src\\test\\resources\\Feature" 
, glue = "com.definition")

public class TestRunner {
	
	

}
