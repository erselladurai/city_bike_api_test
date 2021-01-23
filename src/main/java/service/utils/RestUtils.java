package service.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import service.constants.Constant;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static io.restassured.RestAssured.given;

/**
 * This class for the rest util methods
 */
public abstract class  RestUtils {

    /**
     * Private consumer for set base URI
     */
    private static final Consumer<String> setBaseURI = (baseUri) -> RestAssured.baseURI = baseUri;

    /**
     * Method for set Base URI
     */
    public void setBaseURI(){
        setBaseURI.accept(PropertyUtils.getProperty(Constant.BASEURI));
    }

    /**
     * re-usable method for get call
     * @param serviceEndPoint - resource name
     * @param requestSpec - Request specification
     * @param responseSpec - response specification
     * @return - return the Validatable response object
     */
    public ValidatableResponse get(String serviceEndPoint, RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        return given()
                .when()
                .spec(requestSpec)
                .get(serviceEndPoint)
                .then()
                .spec(responseSpec);
    }

    /**
     * this method convert the country code to country name
     * @param isoCountryCode - country code
     * @return - country name
     */
    public String getCountryNameFromISOCountryCode(String isoCountryCode)
    {
        Locale l = new Locale("", isoCountryCode);
        return l.getDisplayCountry();
    }

    /**
     * Generic method for deserialize the response to class object
     * @param response - Validated response object
     * @param aclass - Class type
     * @param <T> - Generic class type
     * @return - deserialized response
     */
    public <T> T deserializeResponse(ValidatableResponse response, Class<T> aclass){
        return response.extract().body().as(aclass);
    }

    /**
     * this methid to create the default request specification
      * @return return the default request specification object
     */
     public RequestSpecification defaultRequestSpec() {
        return new RequestSpecBuilder()
                .setConfig(
                        RestAssuredConfig.config()
                                .sslConfig(new SSLConfig().relaxedHTTPSValidation().allowAllHostnames())
                                .connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponseAfter(5, TimeUnit.SECONDS))
                ).log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * this methid to create the default response specification
     * @return return the default response specification object
     */
    public ResponseSpecification defaultResponseSpec() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
