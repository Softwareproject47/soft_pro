Feature: Worker management

  Scenario: Add new worker
    Given I have no workers
    When I add a worker with name "Sarah Johnson" and status "available"
    Then I should have 1 worker with name "Sarah Johnson" and status "available"

  Scenario: Update existing worker
    Given I have a worker with name "Tom Smith" and status "busy"
    When I update the status of the worker to "available"
    Then I should have 1 worker with name "Tom Smith" and status "available"

  Scenario: Remove existing worker
    Given I have a worker with name "Sarah Johnson" and status "available"
    When I remove the worker
    Then I should have no workers
