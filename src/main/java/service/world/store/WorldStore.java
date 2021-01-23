package service.world.store;

import io.restassured.response.ValidatableResponse;
import service.model.CityNetworks;

/**
 * World store to store the objects or values during the run time
 */
public class WorldStore {
    private static WorldStore myself = new WorldStore();

    private CityNetworks networksDeserializeGetResponseBody;

    private ValidatableResponse networksGetResponse;

    private WorldStore(){ }

    public ValidatableResponse getNetworksGetResponse() {
        return networksGetResponse;
    }

    public void setNetworksGetResponse(ValidatableResponse networksGetResponse) {
        this.networksGetResponse = networksGetResponse;
    }

    public CityNetworks getNetworksDeserializedGetResponse() {
        return networksDeserializeGetResponseBody;
    }

    public void setNetworksDeserializedGetResponse(CityNetworks networksGetResponse) {
        this.networksDeserializeGetResponseBody = networksGetResponse;
    }

    public static WorldStore getInstance(){
        if(myself == null){
            myself = new WorldStore();
        }
        return myself;
    }

    public void ClearTestData(){
        myself = new WorldStore();
    }
}
