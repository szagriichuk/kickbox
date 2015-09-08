package com.kickbox.java.http.params;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Base abstraction of the Kickbox.io's parameters.
 *
 * @author szagriichuk.
 */
public abstract class Param<T> {
    private static final Logger LOG = LoggerFactory.getLogger(Param.class);
    T value;
    public Param(T param) {
        this.value = param;
    }

    @Override
    public String toString() {
        return name() + "=" + encode(String.valueOf(value));
    }

    public abstract String name();
    public T value(){
        return value;
    }

    private String encode(String data){
        try {
            return URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("Cannot encode request url param.", e);
        }
        return "";
    }
}
