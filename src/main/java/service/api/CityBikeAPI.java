package service.api;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import service.utils.PropertyUtils;

public class CityBikeAPI {
    public Response getCityBikeNetworks(String resource) {
        RestAssured.baseURI =PropertyUtils.getProperty("BASEURI");
        Response res = RestAssured.when().get(resource);
        System.out.println(res.getStatusCode());
        return RestAssured.when().get(resource);
    }
}
