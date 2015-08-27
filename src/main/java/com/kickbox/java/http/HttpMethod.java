package com.kickbox.java.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

/**
 * @author szagriichuk.
 */
public enum HttpMethod {
    GET {
        @Override
        public HttpRequestBase create(String url) {
            return new HttpGet(url);
        }
    };

    public abstract HttpRequestBase create(String url);

}
