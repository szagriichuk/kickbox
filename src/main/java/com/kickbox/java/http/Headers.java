package com.kickbox.java.http;

import com.kickbox.java.http.params.Param;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szagriichuk.
 */
public class Headers {
    public static List<Header> create(Param<?>... params) {
        List<Header> headers = new ArrayList<>();
        if (params != null) {
            for (Param<?> param : params) {
                headers.add(new BasicHeader(param.name(), String.valueOf(param.value())));
            }
        }
        return headers;
    }
}
