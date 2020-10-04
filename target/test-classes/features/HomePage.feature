
@ui
Feature: Home Page Validation
  

  @TC004
  Scenario: Validate Header Links
    Given I have browser opened and url navigated
    Then Below Headers are Displayed
    	|hamburger menu   |
			|amazon prime logo|
			|accounts and list link|
			|return and orders|
			|your prime link|
			|cart link|
