package service.model;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

/**
 * Pojo class for Networks
 */
@JsonPropertyOrder({"networks"})
public class CityNetworks {

    @JsonProperty("networks")
    private List<Network> networks;

    @JsonIgnore
    private Map<String, Object> unknownFields = new HashMap<>();

    @JsonProperty("networks")
    public List<Network> getNetworks() {
        return networks;
    }

    @JsonProperty("networks")
    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    // Capture all other fields that Jackson do not match other members
    @JsonAnyGetter
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    @JsonAnySetter
    public void setUnknownFields(String name, Object value) {
        unknownFields.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityNetworks)) return false;
        CityNetworks that = (CityNetworks) o;
        return networks.equals(that.networks) &&
                unknownFields.equals(that.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(networks, unknownFields);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CityNetworks.class.getSimpleName() + "[", "]")
                .add("networks=" + networks)
                .add("unknownFields=" + unknownFields)
                .toString();
    }
}
