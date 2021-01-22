package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import service.api.CityBikeAPI;
import service.datastore.DataStore;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class CityBikeNetwork {

    @Given("^user makes GET request to (.*) endpoint$")
    public void user_makes_GET_request_to_networks_endpoint(String resourceName) {
        CityBikeAPI city = new CityBikeAPI();
        city.getCityBikeNetworks(resourceName);
        DataStore.getInstance().setNetworksGetResponse(city.getCityBikeNetworks(resourceName));
        System.out.println(DataStore.getInstance().getNetworksGetResponse().asString());
    }

    @When("User will get a {int} response")
    public void User_will_get_valid_response(Integer statusCode) {
        Assert.assertEquals((int) statusCode, DataStore.getInstance().getNetworksGetResponse().getStatusCode());
    }

    @Then("^the response should contain the city as (.*), Country as (.*), Latitude as (.*) and Longitude as (.*)$")
    public void the_response_should_contain_the_city(String city, String country, String latitude, String longitude) throws IOException {
        JSONObject jsonArray = new JSONObject(DataStore.getInstance().getNetworksGetResponse().asString());
        final JSONArray networks = jsonArray.getJSONArray("networks");

        long matchCount = StreamSupport.stream(networks.spliterator(), false).filter(a-> {
            System.out.println(a);
            JSONObject companyArray = new JSONObject(a.toString());
            System.out.println(companyArray);
            final JSONObject locationcompany = companyArray.getJSONObject("location");
            final String locationCity = locationcompany.getString("city");
            final String locationCountry = locationcompany.getString("country");
            final String locationLatitude = String.valueOf(locationcompany.getBigDecimal("latitude"));
            final String locationLongitude = String.valueOf(locationcompany.getBigDecimal("longitude"));

            return locationCity.equals(city) && locationCountry.equals(country) && locationLatitude.equals(latitude) && locationLongitude.equals(longitude);
        }).count();

        Assert.assertTrue(matchCount>0);
    }
}
