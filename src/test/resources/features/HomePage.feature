
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
	
	@TC0015
	Scenario: Validate Accounts and Links Fly Out Pop up
	
	Given I have browser opened and url navigated
	When I move mouse on the "Account and Links" 
	And I Click on "Your Account" Link in the Acocunt and Links Fly Out Pop up
	Then I navigate to "Your Account" Page  