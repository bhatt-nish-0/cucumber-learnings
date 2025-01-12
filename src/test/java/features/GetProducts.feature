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

  Scenario Outline:  this is a test 2
    Given some params what?
    | r            |
    | <jsonActual> |
    Then nothing
    Examples:
    |   jsonActual                                                                                                        |
    |  {"a":3,"b": {"c": [{"peepee":"7","plu":87}, {"peepee":"9","plu":93}, {"peepee":"65","plu":967}]}}                  |
    |  {"a":3,"b": {"c": [{"peepee":"7","plu":87}, {"peepee":"9","plu":93}, {"peepee":"65","plu":967,"chuman":"876"}]}}   |

  Scenario Outline: this is a test 3
    Given some params what bro?
    | mad                                      |
    | <animal>                                 |
    Then nothing
    Examples:
    | animal                                   |
    |  [{"abc":67},{"abc":42},{"abc":90}]      |
    |  [{"abc":37},{"abc":49},{"abc":92}]      |

  Scenario Outline: this is a test 4
    Given some params what bro do?
    | agni                                     |
    | <cat>                                    |
    Then nothing
    Examples:
    | cat                                                       |
    | { "c":298, "d":"deer" , "e" : {"f": {"i.o.popo":23}}}     |
    | { "c":299, "d":"deery" , "e" : {"f": {"i.o.popo":234}}}   |

  Scenario Outline: this is a test 5
    Given some params what bro do doing?
    | aaa                                     |
    | <dog>                                   |
    Then nothing
    Examples:
    |       dog                                                                  |
    |      {"c":234, "der": [{"kan":"pur"},{"kan":"cannes"}]}                    |
    |      {"c":272, "der": [{"kan":"pur"},{"kan":"cannes"} , {"kan":"ratlam"}]} |
    |      {"c":272, "der": [{"kan":"pur"},{"kan":"cannes"} , {"kan":"ratlam"}, {"kan":null}]} |
    |      {"c":272, "der": [{"kan":"pur"},{"kan":"cannes"} , {"kan":"ratlam"}, {"kan":""}]} |

  Scenario Outline:  this is a test 6
    Given some params what bro do doing all? with "<b>"
    |                a                        |                b                 |
    |               <a>                       |               <b>                |
    Then nothing
    Examples:
    |           a                             |                b                 |
    |   {"c":3,"x":"hehe"}                    |                APAC              |
    |   {"c":7,"x":"yoyo"}                    |                EMEA              |
    |   {"c":1,"x":"papa"}                    |                NAM               |

