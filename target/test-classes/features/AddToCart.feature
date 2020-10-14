@tag
Feature: Add to Cart Functionality

  @TC008
  Scenario: Add product in to cart and Validate cart Wondow with product Added
    Given I have browser opened and url navigated
    When I search for product as "Men shoes"
    Then Select any product add in to Cart
    And Validate product Added Successfuly

  @TC0011
  Scenario: User should be able to Remove the item from Add to cart list
    Given I have browser opened and url navigated
    When I added 2 products in the cart
    And Deleted one product from it.
    Then validate cart should update accordigly or not

  @TC0013
    Scenario: User should be able to REmove the item from Add to Cart list
   Given I have browser opened and url navigated
   When I Search products and Added Into Cart
   |Dell|
   |Samsung|
  And Delete product from it.
  Then validate cart should update accordigly or not
  
  @TC0014
  Scenario Outline: User should be able to Remove the items from Add To Cart list
  
  Given I have browser opened and url navigated
  When I Search products as <name> and Added Into Cart
  And Delete one product from it.
  Then I get message as "Your Amazon Basket is empty" 
  
  Examples:
  |name|
  |Laptop|
  |Earphones|
  
  @TC0016
  Scenario: Add to cart Mutiple product of Different Catogories
  Given I have browser opened and url navigated
  When I search for and add single product of each category as below
      | Laptop   |
      | EarPhones |
      | LED TV   |
      | EarPhones |
      | LED TV   |
      | EarPhones   |
      | LED TV  |
      | Computer |
      | LED TV   |
      | Headphone   |   
    Then All the products should be added in the cart
  
  