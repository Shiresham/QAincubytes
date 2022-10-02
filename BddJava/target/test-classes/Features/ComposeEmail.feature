Feature: Compose and Send email through gmail account

  Scenario: User logs in and sends email
    Given There is a user who visits gmail login page
    And User login with username and password 
    When User sends email to other email with Suject and body
    Then email appears in the sent folder of gmail with subject and Body
