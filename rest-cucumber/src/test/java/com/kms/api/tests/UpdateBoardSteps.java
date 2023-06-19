package com.kms.api.tests;

import com.kms.api.model.Board;
import com.kms.api.requests.RequestFactory;
import com.kms.api.util.RequestBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static com.kms.api.util.RestUtil.mapRestResponseToPojo;

public class UpdateBoardSteps {
    private String path = "";
    private Object requestPayload;
    private Board reqUpdateBoard;
    private Board resAddBoard;
    private String id;
    private Response res;

    @Given("the path {string} to the endpoint for update")
    public void thePathToTheEndpointForUpdate(String path) {
        this.path = path;
    }
}
