#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Title of your scenario outline
    Given User Open Souca Demo
    When User Input Username <username>
    When User Input Password <password>
    Then User Submit Button

    Examples: 
      | username        | password     |
      | locked_out_user | secret_sauce |

  @tag2
  Scenario: Title of your scenario outline
    Given User Count Product
    When User Add to Chart Following Product Title
    When User Get Label and Price Product
    And User Verify Remove in Add to Chart
    And User Open Chart
    Then User Verify Label and Price in Your Chart
