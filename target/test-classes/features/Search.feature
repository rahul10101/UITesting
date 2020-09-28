
@search
Feature: Search fuctionality
 

  @TC001
  Scenario: Search a Product
    Given I have browser opened and url navigated
    When I search for product as "Dell"
    Then product list should apper pertaining to the product search as "Dell"
    
  @TC004
  Scenario: User want to search product by using hamberger menu
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step
