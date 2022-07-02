package city;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityResponse {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;

    @Override
    public String toString() {
        return "id:" + id + ": name:" + name;
    }
}