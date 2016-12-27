@calci
Feature: Validate mathematical operations of the basic calculator

  As a end user
  I should be able to perform addition of two number


  Scenario Outline: Addition of two numbers
    Given I have opened the calculator
    When I enter "<val1>"
    And I select addition operation
    And I enter "<val2>"
    And I hit equals button
    Then I should be presented with "<expected>"


    Examples:
     |val1|val2|expected|
    |8   |13  |21      |
    |121 |100 |201     |
    |131 |99  |230     |