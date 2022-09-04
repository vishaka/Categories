Feature: Post Categories_Creates a new category.

  @PostRequest
  Scenario: Happy Path to test post response
    Given Generate the api end point
    Then Create api header
    And Generate the request body "Parleplunkd" and "1937"
    And Send the request with request body and validate 201 response code

  @PostRequest
  Scenario: Happy Path to test post response
    Given Generate the api end point
    Then Create api header
    And Generate the request body "Parleplunkd" and "439"
    And Send the request with request body and validate 400 response code
    Then Validate the error "Validation error"

  @PostRequest
  Scenario Outline: Happy Path to test post response
    Given Generate the api end point
    Then Create api header
    And Generate the request body with values 101 and 3474
    And Send the request with request body and validate <code>
    Then Validate the error <message>
    Examples:
       | code | message              |
      | 500  | "Unexpected token n in JSON at position 1" |

  @PostRequest
  Scenario Outline: Happy Path to test post response
    Given Generate the api end point
    Then Create api header
    And Generate the request body with values "101" and 2345
    And Send the request with request body and validate <code>
    Then Validate the error <message>
    Examples:
      | code | message              |
      | 500  | "Unexpected token n in JSON at position 1" |
