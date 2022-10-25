package com.gitlab.issues.stepDefinition;

import com.gitlab.issues.api.BasePage;
import com.gitlab.issues.api.CreateIssueAPI;
import com.gitlab.issues.api.ReadIssuesAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateIssueSteps {

    @Steps
    CreateIssueAPI createIssueAPI;

    @Steps
    BasePage basePage;


    @Given("^An (.*) user is accessing a Gitlab (.*) repository$")
    public void setupTest(String userType,String repoType) {
        basePage.setupTest(userType, repoType);
    }
    @When("^He Attempts to create an issue with (.*) details$")
    public void createIssue(String type, DataTable dataTable) {
        List<Map<String, String>> issueData = dataTable.asMaps(String.class, String.class);
        createIssueAPI.createIssue(issueData);
    }
    @Then("^Issue (.*) created successfully$")
    public void verifyIsIssueCreated(String createdStatus) {
        if(createdStatus.equalsIgnoreCase("is"))
            assertThat(Serenity.sessionVariableCalled("createIssueResponseCode").toString()).as("Create Issue response code is").isEqualTo("201");
        else
            assertThat(Serenity.sessionVariableCalled("createIssueResponseCode").toString()).as("Create Issue response code is").isNotEqualTo("201");
    }

}
