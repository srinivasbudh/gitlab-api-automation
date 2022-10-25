package com.gitlab.issues.api;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.given;

public class DeleteIssuesAPI {

    /**
     * Method to delete issue using Gitlab API
     * @param iid is the unique id of the project to delete
     */
    @Step
    public void deleteIssues(String iid){
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", Serenity.sessionVariableCalled("token"))
                .when().log().all().delete("/"+iid);
        Serenity.setSessionVariable("deleteIssueResponseCode").to(response.statusCode());
    }

}
