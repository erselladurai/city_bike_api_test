package service.datastore;

import io.restassured.response.Response;

public class DataStore {
    private static DataStore myself = new DataStore();

    public Response getNetworksGetResponse() {
        return networksGetResponse;
    }

    public void setNetworksGetResponse(Response networksGetResponse) {
        this.networksGetResponse = networksGetResponse;
    }

    private Response networksGetResponse;

    private DataStore(){ }

    public static DataStore getInstance(){
        if(myself == null){
            myself = new DataStore();
        }
        return myself;
    }

    public void ClearTestData(){
        myself = new DataStore();
    }
}
