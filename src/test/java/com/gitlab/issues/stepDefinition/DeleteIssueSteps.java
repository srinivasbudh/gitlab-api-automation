package com.gitlab.issues.stepDefinition;

import com.gitlab.issues.api.DeleteIssuesAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteIssueSteps {

    @Steps
    DeleteIssuesAPI deleteIssuesAPI;

    @When("^He Attempts to delete an issue with (.*) details$")
    public void deleteIssues(String iid) {
        deleteIssuesAPI.deleteIssues(iid);
    }

    @Then("^Issue (.*) deleted successfully$")
    public void verifyDelete(String status) {
        if(status.equalsIgnoreCase("is"))
            assertThat(Serenity.sessionVariableCalled("deleteIssueResponseCode").toString()).as("Delete issue response code is").isEqualTo("204");
        else
            assertThat(Serenity.sessionVariableCalled("deleteIssueResponseCode").toString()).as("Delete issue response code is").isNotEqualTo("204");
    }
}
