package auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {
    @JsonProperty("access_token")
    public String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

}