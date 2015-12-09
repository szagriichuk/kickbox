package com.kickbox.java.http;

import com.kickbox.java.model.ExtendedKickBoxResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.kickbox.java.serialize.Serializer.deserialize;

/**
 * Http method executor.
 *
 * @author szagriichuk.
 */
public final class HttpExecutor {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static ExtendedKickBoxResponse execute(HttpRequestBase method) {
        try {
            HttpResponse response = httpClient.execute(method);
            return assignCode(deserialize(entityToString(response), ExtendedKickBoxResponse.class), response);
        } catch (final IOException e) {
            return new ExtendedKickBoxResponse() {{
                message = e.getMessage();
                code = HttpStatus.SC_NOT_FOUND;
            }};
        }
    }

    private static ExtendedKickBoxResponse assignCode(ExtendedKickBoxResponse boxResponse, HttpResponse response) {
        boxResponse.code = response.getStatusLine().getStatusCode();
        return boxResponse;
    }

    private static String entityToString(HttpResponse result) {
        try {
            return EntityUtils.toString(result.getEntity());
        } catch (IOException e) {
            throw new HttpException(e.getMessage());
        }
    }
}
