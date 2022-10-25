package com.gitlab.issues.api;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.given;

public class ReadIssuesAPI {

    /**
     * Method to get all the issues of a Gitlab repository
     */
    @Step
    public void getIssues(){
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", Serenity.sessionVariableCalled("token"))
                .when().log().all().get();
        Serenity.setSessionVariable("getIssueResponseCode").to(response.statusCode());
        Serenity.setSessionVariable("getIssueResponse").to(response.getBody().asString());
        setCountOfIssues(response);
    }

    /**
     * Method to get issues with milestone id from a gitLab
     * @param milestone
     */
    @Step
    public void getIssuesWithMilestone(String milestone){
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", Serenity.sessionVariableCalled("token"))
                .when().log().all().get("?milestone="+milestone);
        Serenity.setSessionVariable("getIssueResponseCode").to(response.statusCode());
        Serenity.setSessionVariable("getIssueResponse").to(response.getBody().asString());
        setCountOfIssues(response);

    }

    private void setCountOfIssues(Response response) {
        if(Serenity.sessionVariableCalled("getIssueResponse").toString().length()>2&&response.statusCode()==200){
            JSONArray arrayOfIssues = new JSONArray(Serenity.sessionVariableCalled("getIssueResponse").toString());
            Serenity.setSessionVariable("getIssueResponseCount").to(arrayOfIssues.length());
        }else
            Serenity.setSessionVariable("getIssueResponseCount").to(0);

    }

    /**
     * Method to verify if a issueNumber exist in the total list of issues
     * @param issueNumber
     * @return
     */
    public boolean verifyIfIssueExist(String issueNumber){
        JSONArray arrayOfIssues = new JSONArray(Serenity.sessionVariableCalled("getIssueResponse").toString());
        for(Object issue:arrayOfIssues){
            JSONObject singleIssue = new JSONObject(issue.toString());
            if(singleIssue.get("id").toString().equals(issueNumber)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to verify if a iid exist in the total list of issues
     * @param iid
     * @return
     */
    public boolean verifyIidExist(int iid){
        JSONArray arrayOfIssues = new JSONArray(Serenity.sessionVariableCalled("getIssueResponse").toString());
        for(Object issue:arrayOfIssues){
            JSONObject singleIssue = new JSONObject(issue.toString());
            if(singleIssue.get("iid").equals(iid)){
                return true;
            }
        }
        return false;
    }

}
