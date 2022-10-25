package com.gitlab.issues.api;

import com.gitlab.issues.models.payload.CreateIssuePayload;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.rest.SerenityRest.given;

public class CreateIssueAPI{

    CreateIssuePayload createIssuePayload = new CreateIssuePayload();

    /**
     * Crete issue using Gitlab API
     * @param issueData is the required data for issue creation
     */
    @Step
    public void createIssue(List<Map<String, String>> issueData){
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization",Serenity.sessionVariableCalled("token"))
                .when().log().all().body(setPayload(issueData)).post("/");
        Serenity.setSessionVariable("createIssueResponseCode").to(response.statusCode());
        Serenity.setSessionVariable("createIssueResponse").to(response.getBody());
        setIssueIdAsSessionVariable(response);
    }

    private void setIssueIdAsSessionVariable(Response response){
        JSONObject createIssueResponse=new JSONObject(response.getBody().asString());
        if(Serenity.sessionVariableCalled("createIssueResponseCode").equals(201)){
            Serenity.setSessionVariable("issueIdForThisRun").to(createIssueResponse.get("id"));
        }else{
            Serenity.setSessionVariable("issueIdForThisRun").to("No_Issue_Created");
        }

    }

    //Below methods are created to set payload base on the dataTable
    private CreateIssuePayload setPayload(List<Map<String, String>> issueData){
        setTitle(issueData);
        setDescription(issueData);
        setConfidential(issueData);
        setLabels(issueData);
        setIssueType(issueData);
        setDueDate(issueData);
        setDiscussionToResolve(issueData);
        setCreatedAt(issueData);
        setWeight(issueData);
        setId(issueData);
        setIid(issueData);
        setEpicId(issueData);
        setEpicIid(issueData);
        setAssigneeId(issueData);
        setAssigneeIds(issueData);
        setMilestoneId(issueData);
        setMergeRequestToResolveDiscussionsOf(issueData);
        return createIssuePayload;
    }

    private void setConfidential(List<Map<String, String>> issueData) {
        String value=issueData.get(0).get("confidential");
        if(value != null)
            createIssuePayload.setConfidential(true);
    }

    private void setCreatedAt(List<Map<String, String>> issueData) {
        createIssuePayload.setCreatedAt(issueData.get(0).get("created_at"));
    }

    private void setDiscussionToResolve(List<Map<String, String>> issueData) {
        createIssuePayload.setDiscussionToResolve(issueData.get(0).get("discussionToResolve"));
    }

    private void setDueDate(List<Map<String, String>> issueData) {
        createIssuePayload.setDueDate(issueData.get(0).get("dueDate"));
    }

    private void setIssueType(List<Map<String, String>> issueData) {
        createIssuePayload.setIssueType(issueData.get(0).get("issueType"));
    }

    private void setLabels(List<Map<String, String>> issueData) {
        createIssuePayload.setLabels(issueData.get(0).get("labels"));
    }

    private void setDescription(List<Map<String, String>> issueData) {
        createIssuePayload.setDescription(issueData.get(0).get("description"));
    }

    private void setTitle(List<Map<String, String>> issueData) {
        createIssuePayload.setTitle(issueData.get(0).get("title"));
    }

    private void setWeight(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("weight");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getWeight();
        else
            createIssuePayload.setWeight(Long.valueOf(value));
    }

    private void setId(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("id");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getId();
        else
            createIssuePayload.setId(Long.valueOf(value));
    }

    private void setIid(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("iid");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getIid();
        else
            createIssuePayload.setIid(Long.valueOf(value));
    }

    private void setEpicId(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("epic_id");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getEpicId();
        else
            createIssuePayload.setEpicId(Long.valueOf(value));
    }


    private void setEpicIid(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("epic_iid");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getEpicId();
        else
            createIssuePayload.setEpicIid(Long.valueOf(value));
    }


    private void setAssigneeId(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("assignee_id");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getAssigneeId();
        else
            createIssuePayload.setAssigneeId(Long.valueOf(value));
    }

    private void setAssigneeIds(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("assignee_ids");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getAssigneeId();
        else
            createIssuePayload.setAssigneeIds(Long.valueOf(value));
    }

    private void setMilestoneId(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("milestone_id");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getMilestoneId();
        else
            createIssuePayload.setMilestoneId(Long.valueOf(value));
    }

    private void setMergeRequestToResolveDiscussionsOf(List<Map<String, String>> issueData){
        String value= issueData.get(0).get("merge_request_to_resolve_discussions_of");
        if(value == null || value.isEmpty() || value.trim().isEmpty())
            createIssuePayload.getMergeRequestToResolveDiscussionsOf();
        else
            createIssuePayload.setMergeRequestToResolveDiscussionsOf(Long.valueOf(value));
    }
}
