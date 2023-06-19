Feature: Add new board

  Scenario: Add new a board
    Given the path "board/create" to the endpoint
    And the payload create of the request with BoardName as "My board1674"
    When I perform the request to add new board
    Then the status code "200" should return
    And the board is added successfully with an string id

