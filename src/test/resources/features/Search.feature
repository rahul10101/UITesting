
@search
Feature: Search fuctionality
 

  @TC001
  Scenario: Search a Product
    Given I have browser opened and url navigated
    When I search for product as "Dell"
    Then product list should apper pertaining to the product search as "Dell"

