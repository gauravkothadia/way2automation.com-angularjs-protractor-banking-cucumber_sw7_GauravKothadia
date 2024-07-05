package com.way2automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", //-----content root path for features directory
        glue = "com/way2automation/steps", //-----source root path for steps package
        plugin = {"html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/cucumber.json"},
        tags = "@smoke",
        dryRun = false
)

public class RunCukeSmokeTest extends AbstractTestNGCucumberTests {
}
