package city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    public int id;
    public String name;

    @Override
    public String toString() {
        return "id:" + id +  ": name:" + name;
    }
}