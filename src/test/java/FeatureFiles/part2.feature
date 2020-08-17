Feature: Part2

  Scenario Outline:New order creation and verification
    Given Navigate to the website
    When Enter the username and password and click on login button
    Then User should login successfully
    When Create the order with "<product>"
    Then User fill the order form and verify it
      | quantity        | 2               |
      | customer name   | Kevin de Bruyne |
      | street          | Etihad Stadium  |
      | city            | Manchester      |
      | state           | England         |
      | zip             | 55555           |
      | card number     | 1010101010      |
      | expiration date | 10/10           |
    Then The order should be added to the all orders table
    Examples:
      | product     |
      | MyMoney     |
      | FamilyAlbum |
      | ScreenSaver |