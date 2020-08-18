Feature: Part3

  Scenario: Checking the order creation functionality with incomplete form
    Given Navigate to the website
    When Enter the username and password and click on login button
    Then User should login successfully
    Then User fill the order form
      | quantity | customer name   | street         | city       | state   | zip   | card number | expiration date |
      |          | Kevin de Bruyne | Etihad Stadium | Manchester | England | 55555 | 1010101010  | 10/10           |
      | 2        |                 | Etihad Stadium | Manchester | England | 55555 | 1010101010  | 10/10           |
      | 2        | Kevin de Bruyne |                | Manchester | England | 55555 | 1010101010  | 10/10           |
      | 2        | Kevin de Bruyne | Etihad Stadium |            | England | 55555 | 1010101010  | 10/10           |
      | 2        | Kevin de Bruyne | Etihad Stadium | Manchester |         | 55555 | 1010101010  | 1010            |
      | 2        | Kevin de Bruyne | Etihad Stadium | Manchester | England |       | 1010101010  | 10/10           |
      | 2        | Kevin de Bruyne | Etihad Stadium | Manchester | England | 55555 |             | 10/10           |
      | 2        | Kevin de Bruyne | Etihad Stadium | Manchester | England | 55555 | 1010101010  |                 |
      | 2        | Kevin de Bruyne | Etihad Stadium | Manchester | England | 55555 | card        | 10/10           |
      | 2        | Kevin de Bruyne | Etihad Stadium | Manchester | England | zip   | 1010101010  | 10/10           |
      | two      | Kevin de Bruyne | Etihad Stadium | Manchester | England | 55555 | 1010101010  | 10/10           |

    Then It should be 8 orders on the page

