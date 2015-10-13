package com.flyfresco.salesforce;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class HttpClientFactory {
    public static CloseableHttpClient newClient(final Context context) {
        return HttpClients.custom().
                setRedirectStrategy(new LaxRedirectStrategy()).
                addInterceptorLast(new HttpRequestInterceptor() {
                    @Override
                    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
                        httpRequest.addHeader("Authorization", "Bearer " + context.getAccessToken());
                        httpRequest.addHeader("Content-Type", "application/json");
                    }
                }).build();
    }
}
