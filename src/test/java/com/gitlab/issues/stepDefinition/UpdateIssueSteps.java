package com.gitlab.issues.stepDefinition;

import com.gitlab.issues.api.UpdateIssuesAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateIssueSteps {

   @Steps
    UpdateIssuesAPI updateIssuesAPI;

    @When("^He Attempts to update an issue with (.*) details$")
    public void updateIssue(String type, DataTable dataTable) {
        List<Map<String, String>> updateData = dataTable.asMaps(String.class, String.class);
        updateIssuesAPI.updateIssues(updateData);
    }
    @Then("Issue is updated successfully")
    public void issue_is_updated_successfully() {
        assertThat(Serenity.sessionVariableCalled("updateIssueResponseCode").toString()).as("Update Issue response code is").isEqualTo("200");
    }
    @Then("^the issue is updated correctly$")
    public void updatedCorrectly(DataTable dataTable) {
        List<Map<String, String>> updateData = dataTable.asMaps(String.class, String.class);
        assertThat(updateIssuesAPI.updatedCorrectly(updateData)).as("Issue is updated correctly").isTrue();
    }

}
