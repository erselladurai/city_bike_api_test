@city_network_test
Feature: As a biker I would like to know the exact location of city bikes around the world in a given application.

  Background:
    Given set the base URI

  Scenario Outline: As a user I want to verify that the given city is in the given country and return their corresponded latitude and longitude
    When user makes GET request to networks endpoint
    Then user will get a 200 response
    And verify that the city <City> is in <Country> and return their corresponded latitude and longitude

    Examples:
      | City              | Country |
      | Frankfurt         | Germany |
      | Neusiedler See    | Austria |
      | Offenbach am Main | Germany |

  Scenario: As a user I want to verify that the Bike Rapid City B-cycle is in the country United States
    When user makes GET request to networks endpoint
    Then user will get a 200 response
    And verify that the bike Rapid City B-cycle is in the country United States

  Scenario Outline: As a user I want to verify the href of the given bike id
    When user makes GET request to networks endpoint
    Then user will get a 200 response
    And verify the href <Href> of the given bike id <Id>
    Examples:
      | Id                   | Href                              |
      | we-love-bike         | /v2/networks/we-love-bike         |
      | bicincitta-selargius | /v2/networks/bicincitta-selargius |
      | bicincitta-chablais  | /v2/networks/bicincitta-chablais  |



