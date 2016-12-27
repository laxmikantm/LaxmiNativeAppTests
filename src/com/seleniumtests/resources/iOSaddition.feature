@iOScalci
Feature: Validate mathematical operations of the basic calculator

  As a end user
  I should be able to perform addition of two number


  Scenario Outline: Addition of two numbers
    Given I have opened the calculator
    When I enter "IntegerA" as "<val1>"
    And I enter "IntegerB" as "<val2>"
    And I hit Compute Sum button
    Then I should be displayed result as "<expected>"


    Examples:
     |val1|val2|expected|
    |8   |13  |21      |
    |121 |100 |201     |
    |131 |99  |230     |