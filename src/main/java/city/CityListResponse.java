package city;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CityListResponse {
    @JsonProperty("response")
    public ArrayList<CityResponse> response;

    public ArrayList<CityResponse> getCityResponse() {
        return response;
    }
}