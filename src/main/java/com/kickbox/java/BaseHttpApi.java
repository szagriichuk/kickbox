package com.kickbox.java;

import com.kickbox.java.http.Headers;
import com.kickbox.java.http.HttpMethod;
import com.kickbox.java.http.params.ApiKey;
import com.kickbox.java.http.params.Param;
import com.kickbox.java.model.ExtendedKickBoxResponse;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.List;

import static com.kickbox.java.http.HttpExecutor.execute;

/**
 * Provides common methods for
 *
 * @author szagriichuk.
 */
abstract class BaseHttpApi extends Key {

    public BaseHttpApi(String key) {
        super(key);
    }

    String createRequestString(String delim, ApiKey apiKey, Param<?>... params) {
        if (params == null || params.length == 0)
            return "";

        return createRequestParams(delim, apiKey, params);
    }

    String createRequestParams(String delim, ApiKey apiKey, Param<?>... params) {
        StringBuilder builder = new StringBuilder();
        builder.append(apiKey).append(delim);
        for (int i = 0; i < params.length - 1; i++) {
            builder.append(params[i]).append(delim);
        }
        builder.append(params[params.length - 1]);
        return builder.toString().trim();
    }

    HttpRequestBase createGetRequestWithHeader(String url, List<Header> headers) {
        HttpRequestBase requestBase = HttpMethod.GET.create(url);
        addHeaders(headers, requestBase);
        return requestBase;
    }

    private void addHeaders(List<Header> headers, HttpRequestBase requestBase) {
        for (Header header : headers) {
            requestBase.addHeader(header);
        }
    }

    ExtendedKickBoxResponse get(String url, Param<?>... params) {
        return get(url, Headers.create(), params);
    }

    ExtendedKickBoxResponse get(String url, List<Header> headers, Param<?>... params) {
        return execute(createGetRequestWithHeader(createUrlWithParams(url + "?", createRequestString("&", new ApiKey(key), params)), headers));
    }

    String createUrlWithParams(String url, String paramsValues) {
        return url + paramsValues;
    }
}
