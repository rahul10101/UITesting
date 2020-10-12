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
  And Deleted one product from it.
  Then validate cart should update accordigly or not