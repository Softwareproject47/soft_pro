Feature: Service management

  Scenario: Add new service
    Given I have no services
    When I add a service with name "Bathroom cleaning" and price 15.0
    Then I should have 1 service with name "Bathroom cleaning" and price 15.0

  Scenario: Update existing service
    Given I have a service with name "Kitchen cleaning" and price 20.0
    When I update the price of the service to 25.0
    Then I should have 1 service with name "Kitchen cleaning" and price 25.0

  Scenario: Remove existing service
    Given I have a service with name "Bathroom cleaning" and price 15.0
    When I remove the service
    Then I should have no services