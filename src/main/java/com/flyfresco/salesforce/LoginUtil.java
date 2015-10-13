package com.flyfresco.salesforce;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Context login(Configuration configuration) throws URISyntaxException, IOException {
        URI uri = new URIBuilder("https://login.salesforce.com/services/oauth2/token").
                setParameter("grant_type", "password").
                setParameter("client_id", configuration.getClientId()).
                setParameter("client_secret", configuration.getClientSecret()).
                setParameter("username", configuration.getUsername()).
                setParameter("password", configuration.getPassword()).build();
        HttpPost httpPost = new HttpPost(uri);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String response = httpClient.execute(httpPost, new BasicResponseHandler());
            LoginResponse loginResponse = OBJECT_MAPPER.readValue(response, LoginResponse.class);
            return new Context(loginResponse);
        }
    }
}
