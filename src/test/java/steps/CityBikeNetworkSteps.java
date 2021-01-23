package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import service.api.CityBikeAPI;

import java.io.IOException;

public class CityBikeNetworkSteps extends CityBikeAPI {

    @Given("^user makes GET request to (.*) endpoint$")
    public void user_makes_GET_request_to_networks_endpoint(String resourceName) {
        makeGetCallToCityBikeNetworks(resourceName);
    }

    @When("user will get a {int} response")
    public void User_will_get_valid_response(Integer statusCode) {
        verifyGetCallResponseCode(statusCode);
    }

    @Then("^verify that the city (.*) is in (.*) and return their corresponded latitude and longitude$")
    public void the_response_should_contain_the_city(String city, String country) {
        verifyCityIsInCountry(city, country);
    }


    @Then("^verify that the bike (.*) is in the country (.*)$")
    public void verify_that_Bike_is_in_country(String bikeName, String country) {
        verifyBikeNameIsInCountry(bikeName, country);
    }

    @Then("^verify the href (.*) of the given bike id (.*)$")
    public void verify_the_href_of_the_given_bike_id(String href, String bikeId) {
        verifyHrefOfBikeId(href, bikeId);
    }
}
