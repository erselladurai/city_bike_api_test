package service.api;

import io.restassured.RestAssured;
import service.model.CityNetworks;
import service.model.Network;
import service.utils.RestUtils;
import service.world.store.WorldStore;

import java.util.Optional;
import java.util.function.Predicate;

import static org.testng.Assert.assertEquals;

public class CityBikeAPI extends RestUtils {

    /**
     * This method will do the get call operation on the given resource and response and Deserialized response body will be
     * stored into the world store
     *
     * @param resource - It is the resource name of the Rest API
     */
    public void makeGetCallToCityBikeNetworks(String resource) {
        WorldStore worldstore = WorldStore.getInstance();
        worldstore.setNetworksGetResponse(get(resource,defaultRequestSpec(),defaultResponseSpec()));
        worldstore.setNetworksDeserializedGetResponse(deserializeResponse(worldstore.getNetworksGetResponse(), CityNetworks.class));
    }

    /**
     * This method will verify the given status code from response
     *
     * @param expectedStatusCode - it is the expected status code
     */
    public void verifyGetCallResponseCode(int expectedStatusCode) {
        int statusCodeFromResponse = WorldStore.getInstance().getNetworksGetResponse().extract().statusCode();
        System.out.println("Expected Status Code : " + expectedStatusCode);
        System.out.println("Actual Status Code : " + statusCodeFromResponse);
        assertEquals(expectedStatusCode, statusCodeFromResponse);
    }

    /**
     * This will verify the city is in the country
     *
     * @param city        - city name
     * @param countryCode - country code
     */
    public void verifyCityIsInCountry(String city, String countryCode) {
        Predicate<Network> cityFilterPredicate = network -> network.getLocation().getCity().equalsIgnoreCase(city);

        CityNetworks cityNetworks = WorldStore.getInstance().getNetworksDeserializedGetResponse();
        Optional<Network> network = cityNetworks.getNetworks().stream().filter(cityFilterPredicate).findFirst();

        network.ifPresent(value -> assertEquals(countryCode, getCountryNameFromISOCountryCode(value.getLocation().getCountry())));
        System.out.println("City : " + city);
        System.out.println("Expected Country Name: " + countryCode);
        System.out.println("Actual Country Name : " + getCountryNameFromISOCountryCode(network.get().getLocation().getCountry()));
        System.out.println("Latitude : " + network.get().getLocation().getLatitude());
        System.out.println("Longitude : " + network.get().getLocation().getLatitude());
    }

    /**
     * This method will verify the city is in the countryCode
     * @param bikeName - bike name
     * @param countryCode - Country code
     */
    public void verifyBikeNameIsInCountry(String bikeName, String countryCode) {
        Predicate<Network> bikeNameFilterPredicate = network -> network.getName().equalsIgnoreCase(bikeName);

        CityNetworks cityNetworks = WorldStore.getInstance().getNetworksDeserializedGetResponse();
        Optional<Network> network = cityNetworks.getNetworks().stream().filter(bikeNameFilterPredicate).findFirst();

        network.ifPresent(value -> assertEquals(getCountryNameFromISOCountryCode(value.getLocation().getCountry()), countryCode));
        System.out.println("Bike Name : " + bikeName);
        System.out.println("Expected Country Name: " + countryCode);
        System.out.println("Actual Country Name : " + getCountryNameFromISOCountryCode(network.get().getLocation().getCountry()));
    }

    /**
     * This method is to verify the href of the given bike id
     * @param id - id of the Bike
     * @param href - href of the bike
     */
    public void verifyHrefOfBikeId(String href, String id) {
        Predicate<Network> bikeNameFilterPredicate = network -> network.getId().equalsIgnoreCase(id);

        CityNetworks cityNetworks = WorldStore.getInstance().getNetworksDeserializedGetResponse();
        Optional<Network> network = cityNetworks.getNetworks().stream().filter(bikeNameFilterPredicate).findFirst();

        network.ifPresent(value -> assertEquals(value.getHref(), href));
        System.out.println("Bike Id : " + id);
        System.out.println("Expected Href: " + href);
        System.out.println("Actual Href : " + network.get().getHref());
    }
}
