@tag
Feature: Test Job Portal Functionality

  @tag1
  Scenario: Test login page with valid credentials  
    Given Open chrome and start application
    When User enter valid username and password
    Then User Should be able to login successfully

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step
#
#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
