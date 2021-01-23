package service.model;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Pojo class for Location
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"city", "country", "latitude", "longitude"})
public class Location {
    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("latitude")
    private Integer latitude;

    @JsonProperty("longitude")
    private Integer longitude;

    @JsonIgnore
    private Map<String, Object> unknownFields = new HashMap<>();

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("latitude")
    public Integer getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Integer getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
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
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return city.equals(location.city) &&
                country.equals(location.country) &&
                latitude.equals(location.latitude) &&
                longitude.equals(location.longitude) &&
                unknownFields.equals(location.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, latitude, longitude, unknownFields);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Location.class.getSimpleName() + "[", "]")
                .add("city='" + city + "'")
                .add("country='" + country + "'")
                .add("latitude=" + latitude)
                .add("longitude=" + longitude)
                .add("unknownFields=" + unknownFields)
                .toString();
    }
}
