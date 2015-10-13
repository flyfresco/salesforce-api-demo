package com.flyfresco.salesforce;

public class Context {
    private final String endpoint;
    private final String accessToken;

    public Context(LoginResponse loginResponse) {
        this.endpoint = loginResponse.getInstanceUrl();
        this.accessToken = loginResponse.getAccessToken();
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return "Context{" +
                "endpoint='" + endpoint + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
