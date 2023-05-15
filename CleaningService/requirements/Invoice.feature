Feature: Invoicing

  As a customer
  I want to receive an invoice
  So that I can pay for the services I received

  Scenario: Generate invoice for a completed order
    Given an order with ID 1 is completed
    When I request an invoice for order ID 1
    Then I receive an invoice with the total price of the order

  Scenario: Generate invoice for an incomplete order
    Given an order with ID 2 is not completed
    When I request an invoice for order ID 2
    Then I receive an error message saying the order is not completed

  Scenario: Apply discount for orders over $100
    Given an order with ID 3 has a total price of $150
    When I request an invoice for order ID 3
    Then I receive an invoice with a 10% discount applied
    And the total price is $135