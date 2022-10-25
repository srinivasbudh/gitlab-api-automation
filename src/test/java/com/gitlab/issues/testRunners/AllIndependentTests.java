package com.gitlab.issues.testRunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/CreateIssue.feature",
                            "src/test/resources/features/ReadIssue.feature",
                            "src/test/resources/features/UpdateIssue.feature"},
        glue = "com.gitlab.issues.stepDefinition",tags = "@Regression")
public class AllIndependentTests {
}
