@product
Feature: Update an existing board
  Scenario: Update a board
    Given the path "board/update" to the endpoint
    And the payload of the request with BoardName as "My board16741" and BoardId as "64829db722e75e279f1f22d3"
    When I perform the request to update board
    Then the status code "200" should return

