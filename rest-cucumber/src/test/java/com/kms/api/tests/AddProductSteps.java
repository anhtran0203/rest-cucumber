package com.kms.api.tests;

import static com.kms.api.util.RestUtil.mapRestResponseToPojo;

import com.kms.api.model.Board;
import com.kms.api.requests.RequestFactory;
import com.kms.api.util.RequestBuilder;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;

public class AddProductSteps extends TestBase {

  private String path = "";
  private Object requestPayload;
  private Board reqAddBoard;
  private Board reqUpdateBoard;
  private Board resAddBoard;
  private String id;
  private Response res;

  @Given("^the path \"([^\"]*)\" to the endpoint$")
  public void thePathToAddTheProduct(String path) {
    this.path = path;
  }

  @And("^the payload create of the request with BoardName as \"([^\"]*)\"$")
  public void thePayloadOfTheRequestWithBoardNameAs(String boardName) {
//    String[] array = feature.split(",");
//    List<String> lst = Arrays.asList(array);
    id = "64829db722e75e279f1f22d3";
    requestPayload = RequestBuilder.requestPayload(boardName);
  }

  @When("^I perform the request to add new board$")
  public void iPerformTheRequestToApplication() {
    try{
      reqAddBoard = (Board) requestPayload;
      res = RequestFactory.addProduct(path, reqAddBoard);
      reqAddBoard = mapRestResponseToPojo(res, Board.class);
    } catch (Exception ex) {
      res = RequestFactory.addProduct(path, reqAddBoard);
    }
  }

  @Then("^the status code \"([^\"]*)\" should return$")
  public void theStatusCodeShouldReturn(String statusCode) {
    ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
  }

  @And("^the board is added successfully with an string id$")
  public void theProductIsAddedSuccessfullyWithAnIntegerId() {
    ValidationUtil.validateStringEqual(reqAddBoard.getId(), id);
  }

  @But("I supply invalid json payload")
  public void iSupplyInvalidJsonPayload() {
    requestPayload = "ERROR";
  }
//  @Given("^the path \"([^\"]*)\" to the endpoint$")
//  public void thePathToUpdateTheProduct(String path) {
//    this.path = path+"/64829db722e75e279f1f22d3";
//  }

  @And("the payload of the request with BoardName as \"([^\"]*)\" and BoardId as \"([^\"]*)\"$")
  public void thePayloadOfTheRequestWithBoardNameAsAndBoardIdAs(String boardName, String boardId) {
    id = "64829db722e75e279f1f22d3";
    requestPayload = RequestBuilder.requestPayloadUpdate(boardName, boardId);
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

  @After
  public void teardown() {
    res = RequestFactory.deleteProduct("delete/"+id);
    ValidationUtil.validateStringEqual(String.valueOf(id), res.thenReturn().getBody().asString());
  }
}
