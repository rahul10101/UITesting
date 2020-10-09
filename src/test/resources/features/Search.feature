
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
				
	@TC005
		Scenario: Validate Search product Refinements for Product Type "Refrigerator"
			Given I have browser opened and url navigated
			When I search for product as "Refrigerator"
			Then Below Search product refinement should displayed
					|Amazon Prime|
					|Department|
					|Avg. Customer Review| 
					|Brand|
					|Filters|
	
	@TC006
			Scenario: A user want to serach a product under price range
				Given I have browser opened and url navigated
    		When I search for product as "Dell"
    		Then product should be displayed sorted by price range
    
  @TC007
  		Scenario: Verify Pegination on product Search Page
  				Given I have browser opened and url navigated
   				When I search for product as "Dell"
    			Then Pegination panel with products of first page are displayed by default
    			And page links of previous page and next page workign as per expectation 

   @TC009
   Scenario: A user Entered any Keyword in Search then in Search dropdown it should display appropriate option which is entered in the Search.
   Given I have browser opened and url navigated
   When I search for product as "Samsung" in search box
   Then I am able to see autosuggetion option having keyword "Samsung" .
   
   @TC0010
   Scenario: Add products and Check SubTotal of Cart is Correct
   Given I have browser opened and url navigated
   When I Search products and Added Into Cart
   |Dell|
   |Samsung|
   |Computer|
   Then The Subtotal Is Total Of All Products In Cart  
 