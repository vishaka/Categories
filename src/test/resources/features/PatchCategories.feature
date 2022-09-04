Feature: Patch Categories_Update a category.

  @PatchRequest
  Scenario: Happy Path to test post response
    Given Generate the api end point to update id 107
    Then Create api header
    And Generate the request body "Parleplunks" and "107"
    And Send the patch request with request body and validate 200 response code


  @PatchRequest
  Scenario Outline: Happy Path to test post response
    Given Generate the api end point to update id 107
    Then Create api header
    And Generate the request body with values "107" and 2345
    And Send the patch request with request body and validate <code> response code
    Then Validate the error <message>
    Examples:
      | code | message              |
      | 500  | "Unexpected token n in JSON at position 1" |
