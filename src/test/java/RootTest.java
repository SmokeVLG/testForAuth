import auth.Root;
import city.CityListResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class RootTest {
    public static final String URL_GET_TOKEN = "https://virtserver.swaggerhub.com/denisov.maxim/authTest/1.0.0/auth";
    public static final String URL_GET_LIST_CITY = "https://virtserver.swaggerhub.com/denisov.maxim/authTest/1.0.0/city";
    public static final String LOGIN = "maxden";
    public static final String PASSWORD = "12345678";

    @Test
    public void test1() throws URISyntaxException {
        System.out.println("get token by login and password");
        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.setContentType(MediaType.APPLICATION_JSON);
        authHeaders.set("login", LOGIN);
        authHeaders.set("password", PASSWORD);
        ResponseEntity<Root> authResponse = new RestTemplate()
                .exchange(new URI(URL_GET_TOKEN), HttpMethod.GET, new HttpEntity<>("", authHeaders), Root.class);
        String token = authResponse.getBody().getResponse().getAccessToken();
        System.out.println("get list city by token");


        HttpHeaders cityListHeaders = new HttpHeaders();
        cityListHeaders.setContentType(MediaType.APPLICATION_JSON);
        cityListHeaders.set("token", token);
        System.out.println("token:" + token);

        ResponseEntity<CityListResponse> rateResponse =
                new RestTemplate().exchange(URL_GET_LIST_CITY,
                        HttpMethod.GET, null, new ParameterizedTypeReference<CityListResponse>() {
                        });
        CityListResponse cityListResponse = rateResponse.getBody();

        ArrayList<city.Response> response = cityListResponse.getCityResponse();
        System.out.println("city list:" + response.toString());

        Assert.assertEquals(response.size(), 3);
    }
}
