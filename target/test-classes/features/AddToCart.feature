
@tag
Feature: Add to Cart Functionality
 
  @TC008
  Scenario: Add product in to cart and Validate cart Wondow with product Added
     	Given I have browser opened and url navigated
   	 	When I search for product as "Men shoes"
    	Then Select any product add in to Cart 
   		And Validate product Added Successfuly 

 # @TC0011
  #Scenario: Check SubTotal of Cart isCorrect
  #Given I have browser opened and url navigated
  #When I search for product as "Water Purifire"
  #Then The SubTotal of products is Total of All products In cart