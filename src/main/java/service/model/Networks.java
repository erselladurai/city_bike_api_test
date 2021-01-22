package service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Networks {
    private String[] company;
    private String href;
    private String id;
    private Location location;
    private String name;

    public String[] getCompany() {
        return company;
    }

    public void setCompany(String[] company) {
        this.company = company;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
