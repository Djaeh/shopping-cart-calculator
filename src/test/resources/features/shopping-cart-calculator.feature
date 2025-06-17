Feature: Calculate shopping cart total price

  Scenario: Empty shopping cart for an individual
    Given an individual
    And an empty shopping cart
    When calculation is done
    Then total price is 0

  Scenario: Empty shopping cart for a big company
    Given a big company
    And an empty shopping cart
    When calculation is done
    Then total price is 0

  Scenario: Empty shopping cart for a small company
    Given a small company
    And an empty shopping cart
    When calculation is done
    Then total price is 0

  Scenario: Full shopping cart for an individual
    Given an individual
    And a shopping cart containing
      | id | productName                 | quantity |
      | 1  | "High quality smartphone"   | 2        |
      | 2  | "Middle quality smartphone" | 1        |
      | 3  | "laptop"                    | 3        |
    When calculation is done
    Then total price is 7400

  Scenario: Full shopping cart for a small company
    Given a small company
    And a shopping cart containing
      | id | productName                 | quantity |
      | 1  | "High quality smartphone"   | 2        |
      | 2  | "Middle quality smartphone" | 1        |
      | 3  | "laptop"                    | 3        |
    When calculation is done
    Then total price is 5900

  Scenario: Full shopping cart for a big company
    Given a big company
    And a shopping cart containing
      | id | productName                 | quantity |
      | 1  | "High quality smartphone"   | 2        |
      | 2  | "Middle quality smartphone" | 1        |
      | 3  | "laptop"                    | 3        |
    When calculation is done
    Then total price is 5250

  Scenario: One item shopping cart for an individual
    Given an individual
    And a shopping cart containing
      | id | productName                 | quantity |
      | 2  | "Middle quality smartphone" | 10       |
    When calculation is done
    Then total price is 8000

  Scenario: One item shopping cart for a small company
    Given a small company
    And a shopping cart containing
      | id | productName               | quantity |
      | 1  | "High quality smartphone" | 5        |
    When calculation is done
    Then total price is 5750

  Scenario: One item shopping cart for a big company
    Given a big company
    And a shopping cart containing
      | id | productName | quantity |
      | 3  | "laptop"    | 30       |
    When calculation is done
    Then total price is 27000
