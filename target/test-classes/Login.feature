Feature: Login scenarios
  Scenario Outline: Login with invalid username
    When I enter invalid username "<username>"
    And I enter valid password "<password>"
    And click on the login button
    Then I should see error message "<error>"

    Examples:
      | username | password | error
      | invalidusername | password | some message