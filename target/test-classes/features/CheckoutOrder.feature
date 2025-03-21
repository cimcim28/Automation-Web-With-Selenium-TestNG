Feature: Checkout the order from saucedemo

  Background: Buyer landed to website
    Given Buyer landing to ecommerce

  Scenario: Create Order Positive Case
    Given Buyer logged to website
    When Buyer add product to Cart and checkout
    And Buyer add checkout information
    Then Buyer will see message overview order and on finish order
    Then Buyer confirmation page THANKYOU FOR THE ORDER.