package auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenListResponse {
    @JsonProperty("response")
    public TokenResponse response;
    public TokenResponse getResponse() {
        return response;
    }
}


