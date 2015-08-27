package com.kickbox.java.http;

import com.kickbox.java.model.KickBoxResponse;
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

    public static KickBoxResponse execute(HttpRequestBase method) {
        try {
            HttpResponse response = httpClient.execute(method);
            checkIfStatusIsSuccess(response);
            return deserialize(EntityUtils.toString(response.getEntity()), KickBoxResponse.class);
        } catch (IOException e) {
            throw new HttpException("The operation cannot be executed.", e);
        }
    }

    private static void checkIfStatusIsSuccess(HttpResponse result) {
        if (result.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            throw new HttpException(result.getStatusLine().getReasonPhrase());
        }
    }
}
