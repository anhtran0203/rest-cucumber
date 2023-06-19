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

    @And("the payload of the request with BoardName as {string} and BoardId as {string}")
    public void thePayloadOfTheRequestWithBoardNameAsAndBoardIdAs(String boardName, String boardId) {
        id = "64829db722e75e279f1f22d3";
        requestPayload = RequestBuilder.requestPayload(boardName);
    }

    @When("I perform the request to update board")
    public void iPerformTheRequestToUpdateBoard() {
        try{
            reqUpdateBoard = (Board) requestPayload;
            res = RequestFactory.updateProduct(path, reqUpdateBoard);
            reqUpdateBoard = mapRestResponseToPojo(res, Board.class);
        } catch (Exception ex) {
            res = RequestFactory.updateProduct(path, reqUpdateBoard);
        }
    }
}
