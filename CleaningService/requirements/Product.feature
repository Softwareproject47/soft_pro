Feature: Product management

  Scenario: Add new product
    Given I have no products
    When I add a product with name "Toilet cleaner" and price 5.0
    Then I should have 1 product with name "Toilet cleaner" and price 5.0

  Scenario: Update existing product
    Given I have a product with name "Floor cleaner" and price 10.0
    When I update the price of the product to 12.0
    Then I should have 1 product with name "Floor cleaner" and price 12.0

  Scenario: Remove existing product
    Given I have a product with name "Toilet cleaner" and price 5.0
    When I remove the product
    Then I should have no products