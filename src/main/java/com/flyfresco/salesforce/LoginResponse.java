package com.flyfresco.salesforce;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    private final String accessToken;
    private final String instanceUrl;

    @JsonCreator
    public LoginResponse(@JsonProperty("access_token") String accessToken,
                         @JsonProperty("instance_url") String instanceUrl) {
        this.accessToken = accessToken;
        this.instanceUrl = instanceUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }
}
