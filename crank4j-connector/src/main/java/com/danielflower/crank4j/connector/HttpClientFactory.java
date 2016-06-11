package com.danielflower.crank4j.connector;

import com.danielflower.crank4j.sharedstuff.Crank4jException;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class HttpClientFactory {

    public static HttpClient startedClient() {
        HttpClient client = new HttpClient(new SslContextFactory(true));
        client.setFollowRedirects(false); // redirects should be proxied

        try {
            client.start();
        } catch (Exception e) {
            throw new Crank4jException("Error while starting HttpClient", e);
        }

        client.getContentDecoderFactories().clear(); // don't decode things like gzip - must be after start() is called

        return client;
    }

}