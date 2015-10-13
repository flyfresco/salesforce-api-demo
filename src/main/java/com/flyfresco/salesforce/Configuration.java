package com.flyfresco.salesforce;

public class Configuration {
    private final String clientId;
    private final String clientSecret;
    private final String username;
    private final String password;

    public Configuration(String clientId, String clientSecret, String username, String password) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
