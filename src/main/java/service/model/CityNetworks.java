package service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CityNetworks {
    private Networks[] networks;

    public Networks[] getNetworks() {
        return networks;
    }

    public void setNetworks(Networks[] networks) {
        this.networks = networks;
    }


}
