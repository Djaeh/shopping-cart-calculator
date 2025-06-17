Feature: Calculate shopping cart total price

  Scenario: Empty shopping cart for an individual
    Given an individual
    And an empty shopping cart
    Then total price is 0

  Scenario: Empty shopping cart for a big company
    Given a big company
    And an empty shopping cart
    Then total price is 0

  Scenario: Empty shopping cart for a small company
    Given a small company
    And an empty shopping cart
    Then total price is 0