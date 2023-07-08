Feature: Verify Adactin Login Details

  Scenario Outline: Verifying Adactin Login Details with Valid Credentials
    Given User is on the Adactin Page
    When User should enter "<username>", "<password>"
    Then User should verify after login"Hello Selvaraj"

    Examples: 
      | username    | password |
      | Selvarajd12 | C6T72M   |

      
      