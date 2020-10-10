
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
			
		@TC0012
		
		Scenario: Verify That The User Is Able To Log In To The Application With Valid Email Id And Valid Password 
	Given I have browser opened and url navigated
	When I click on Login And Enter Valid Creadentials
	Then I login Successfully