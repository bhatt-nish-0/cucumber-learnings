Feature: Insert Product using POST Api

  Scenario Outline: Validate post product API works correctly
    Given I hit the url of post product api endpoint
    When  I pass the url of products in the request
    And I pass the request body of product title <ProductTitle>
    Then  I receive the response code as 200
    Examples:
    | ProductTitle |
    |    xxx56123       |

  Scenario Outline: Pass JSON to step
    Given the following JSON data:
    """
    {
        "test": "<test>",
        "a": {
            "b": <b>
        },
        "c" : "<phi>"
    }
    """
    Examples:
    | test    | b  | phi  |
    | 123     | 3  |  x   |
    | 223     | 5  |  y2k   |