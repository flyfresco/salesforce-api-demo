package com.flyfresco.salesforce;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;

public class Demo {
    public static void main(String...args) throws Exception {
        String clientId = "";
        String clientSecret = "";
        String username = "";
        String password = "";

        Configuration configuration = new Configuration(clientId, clientSecret, username, password);
        Context context = LoginUtil.login(configuration);
        System.out.println("Login ok: : " + context);

        try (CloseableHttpClient httpClient = HttpClientFactory.newClient(context)) {
            HttpGet httpGet = new HttpGet(context.getEndpoint() + "/services/apexrest/Test");
            String getResponse = httpClient.execute(httpGet, new BasicResponseHandler());
            System.out.println("GET response: " + getResponse);

            HttpPost httpPost = new HttpPost(context.getEndpoint() + "/services/apexrest/Test");
            String postResponse = httpClient.execute(httpPost, new BasicResponseHandler());
            System.out.println("POST response: " + postResponse);
        }
    }
}
