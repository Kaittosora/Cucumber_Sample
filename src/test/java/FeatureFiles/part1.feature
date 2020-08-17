Feature: Part1
  Scenario:Verify order count
    Given Navigate to the website
    When Enter the username and password and click on login button
    Then User should login successfully
    Then It should be 8 orders on the page
    When Delete all orders
    Then All orders page should be empty

