package com.StepDefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="OrangeHRMApplication"//Feature file folder name
,glue="com.StepDefinition" //Package name where we given TestRunner class
,monochrome = true)
//dryRun = true


public class TestRunner {

}
