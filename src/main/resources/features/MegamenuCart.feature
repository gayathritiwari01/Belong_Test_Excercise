@MegamenuCart @automationpractise
Feature: Registration
  As a user
  I want to summer dresses of  automation practice website
  So that I can successfully add them to cart

  @megamenu
  Scenario: Add a summer dress to cart
    Given I am at the megamenu page
    When I navigate to Summer Dresses via megamenu Dresses
    And I should be able to add a dress to the cart
    And I navigate to the Cart Summary page
    Then I should see product details
    	| productname   | Printed Summer Dress  |
			| productcolor  | Yellow   |
			| productqty    | 1 |