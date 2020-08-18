Feature: Part 4

  Scenario: Verify order details
    Given Navigate to the website
    When Enter the username and password and click on login button
    Then User should login successfully
    Then Verify the data for the Bob Feather
      | FamilyAlbum | 14, North av. | Milltown, WI | US | 81734 | VISA | 111222111222 | 06/08 |