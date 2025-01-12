Feature: Get All Products From the API

  Scenario: Verify the GET API for the products
    Given I hit the url of get products api endpoint
    When  I pass the url of products in the request
    Then  I receive the response code as 200

  Scenario Outline: Verify the rate of the first product is correct
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is <FirstProductRate>
    Examples:
      | FirstProductRate |
      | 3.9              |

  Scenario Outline: this is a test
    Given some parameters
    | a   | acd | bcd | ord   |
    | <c> | <p> | <lo>| <qpd> |
    Then nothing

    Examples:
    |c | p | lo | qpd |
    |x | 3 | 7  | 4,9   |
    |y | 7 | 9  | 2,6   |