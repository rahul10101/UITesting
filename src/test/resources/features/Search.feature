
@search
Feature: Search fuctionality
 

  @TC001
  Scenario: Search a Product
    Given I have browser opened and url navigated
    When I search for product as "Dell"
   	Then product list should apper pertaining to the product search as "Dell"

@TC002
		Scenario: User Want to Search Product for Product using Hamburger Menu in the Header Section
			Given I have browser opened and url navigated
			When I click on hamberger menu
			And I click on hamberger menu with category as "Mobiles, Computers"
			And I click on hamberger menu with sub category as "Power Banks"
			Then Search result are displayed for product related to "Power Banks" 

@TC003
		Scenario: A user should be able to click On a product Link from the search page and product Description page should be displayed.
				Given I have browser opened and url navigated
				When I search for product as "Dell"
				And I click on any product in the Search Result 
				Then I am able to see product description and details in new tab