package com.gitlab.issues.api;

import com.gitlab.issues.models.payload.UpdateIssuePayload;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class UpdateIssuesAPI {
    UpdateIssuePayload updateIssuePayload = new UpdateIssuePayload();

    /**
     * Method to update a Issue on a git lab project
     * @param updateData required data for updating a issue
     */
    @Step
    public void updateIssues(List<Map<String, String>> updateData){
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", Serenity.sessionVariableCalled("token"))
                .when().log().all().body(setPayload(updateData)).put("/"+updateData.get(0).get("iid"));
        Serenity.setSessionVariable("updateIssueResponseCode").to(response.statusCode());
        Serenity.setSessionVariable("updateIssueResponse").to(response.getBody().asString());
    }

    private UpdateIssuePayload setPayload(List<Map<String, String>> updateData){
        updateIssuePayload.setTitle(updateData.get(0).get("title"));
        updateIssuePayload.setCreatedAt(updateData.get(0).get("created_at"));
        updateIssuePayload.setStateEvent(updateData.get(0).get("state_event"));
        setMilestoneId(updateData);
        return updateIssuePayload;
    }

    private void setMilestoneId(List<Map<String, String>> updateData){
        String value= updateData.get(0).get("milestone_id");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            updateIssuePayload.getMilestoneId();
        else
            updateIssuePayload.setMilestoneId(Long.valueOf(value));
    }

    /**
     * Method to to verify if issue is updated correctly
     * @param updateData
     * @return
     */
    public boolean updatedCorrectly(List<Map<String, String>> updateData){
        JSONObject updateIssueResponse=new JSONObject(Serenity.sessionVariableCalled("updateIssueResponse").toString());

        String titleValue= updateData.get(0).get("title");
        if(titleValue != null){
            assertThat(titleValue.equalsIgnoreCase(updateIssueResponse.getString("title"))).as("title is expected to be updated correctly").isTrue();
        }
        String milestoneValue= updateData.get(0).get("milestone_id");
        if(milestoneValue != null){
            JSONObject milestoneObject = new JSONObject(updateIssueResponse.get("milestone").toString());
            assertThat(milestoneValue.equalsIgnoreCase(milestoneObject.get("id").toString())).as("milestone_id is expected to be updated correctly").isTrue();
        }
        String stateValue= updateData.get(0).get("state_event");
        if(stateValue!= null){
            assertThat(updateIssueResponse.getString("state").contains(stateValue)).as("state_event is expected to be updated correctly").isTrue();
        }

        String createdAtValue= updateData.get(0).get("created_at");
        if(createdAtValue!=null){
            assertThat(createdAtValue.equalsIgnoreCase(updateIssueResponse.getString("created_at"))).as("created_at is expected to be updated correctly").isTrue();
        }
        return true;
    }

}
