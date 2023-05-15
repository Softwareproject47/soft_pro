Feature: Customer management

  Scenario: Add new customer
    Given I have no customers
    When I add a customer with name "John Smith" and email "john@example.com"
    Then I should have 1 customer with name "John Smith" and email "john@example.com"

  Scenario: Update existing customer
    Given I have a customer with name "Jane Doe" and email "jane@example.com"
    When I update the email of the customer to "jane.doe@example.com"
    Then I should have 1 customer with name "Jane Doe" and email "jane.doe@example.com"

  Scenario: Remove existing customer
    Given I have a customer with name "John Smith" and email "john@example.com"
    When I remove the customer
    Then I should have no customers

  Scenario: Notify a customer when an order with status "Complete" is complete
    Given a cleaning service application
    And an order with ID 1234 and status "Complete"
    When the admin notifies the customer that the order is complete
    Then a notification should be sent to the customer
    And the notification should indicate that order 1234 is complete