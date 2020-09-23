
@ui
Feature: Home Page Validation
  

  @tag1
  Scenario: Validate Header links
    Given I havebrowser opened and url navigated
    Then Below header links are displayed
    
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
