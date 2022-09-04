Feature: Get Categories_Returns all categories that match the given filter criteria.

  @GetRequest
  Scenario: Happy Path to get the categories api response
    Given Generate the api end point with out limit and skip value
    Then Create api header
    And Send the request and validate 200 response code

  @GetRequest
  Scenario Outline: Happy Path to get the categories api response
    Given Generate the api end point with limit <limitValue> and skip value <skip>
    Then Create api header
    And Send the request and validate <responsecode> response code
    Examples:
      | limitValue | skip | responsecode |
      | 0          | 0    | 200          |
      | 10         | 9    | 200          |

  @GetRequest
  Scenario Outline: Happy Path to get the categories api response
    Given Generate the api end point with limit "<limitValue>" and skip value "<skip>"
    Then Create api header
    And Send the request and validate <responsecode> response code
    Then Validate the error "<message>"
    Examples:
      | limitValue | skip | responsecode | message                             |
      | random     | 3    | 500          | SQLITE_ERROR: no such column: NaN |
      | 10         | Test | 500          | SQLITE_ERROR: no such column: NaN |