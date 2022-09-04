Feature: Get Categories_Returns all categories that match the given filter criteria.

  @GetSpecificRequest
  Scenario: Happy Path to get the categories api response
    Given Generate the api end point with specific 107
    Then Create api header
    And Send the request and validate 200 response code
    Then Validate the reponse message contains "107"

  @GetSpecificRequest
  Scenario: Happy Path to get the categories api response
    Given Generate the api end point with specific 1007
    Then Create api header
    And Send the request and validate 404 response code
    Then Validate the error "No record found for id '1007'"


  @GetSpecificRequest
  Scenario: Happy Path to get the categories api response
    Given Generate the api end point with specific "yurd"
    Then Create api header
    And Send the request and validate 404 response code
    Then Validate the error "No record found for id 'yurd'"