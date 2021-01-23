package service.model;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

/**
 * Pojo class for Network
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"company", "href", "id", "location", "name"})
public class Network {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @JsonProperty("company")
    private List<String> company;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("name")
    private String name;

    @JsonProperty("company")
    private List<String> getCompany() {
        return company;
    }

    @JsonIgnore
    private Map<String, Object> unknownFields = new HashMap<>();

    @JsonProperty("company")
    public void setCompany(List<String> company) {
        this.company = company;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof Network)) return false;
        Network network = (Network) o;
        return company.equals(network.company) &&
                href.equals(network.href) &&
                id.equals(network.id) &&
                location.equals(network.location) &&
                name.equals(network.name) &&
                unknownFields.equals(network.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, href, id, location, name, unknownFields);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Network.class.getSimpleName() + "[", "]")
                .add("company=" + company)
                .add("href='" + href + "'")
                .add("id='" + id + "'")
                .add("location=" + location)
                .add("name='" + name + "'")
                .add("unknownFields=" + unknownFields)
                .toString();
    }
}
