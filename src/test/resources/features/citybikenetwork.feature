Feature: As a biker I would like to know the exact location of city bikes around the world in a given application.

  @city_network_test
  Scenario Outline: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    Given user makes GET request to networks endpoint
    Then User will get a 200 response
    And the response should contain the city as <City>, Country as <Country>, Latitude as <Latitude> and Longitude as <Longitude>

    Examples:
      | City              | Country | Latitude | Longitude |
      | Frankfurt         | DE      | 50.1072  | 8.66375   |
      | Neusiedler See    | AT      | 47.839   | 16.761    |
      | Offenbach am Main | DE      | 50.1093  | 8.73825   |


