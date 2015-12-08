package com.kickbox.java;

import com.kickbox.java.http.params.Email;
import com.kickbox.java.http.params.Timeout;
import com.kickbox.java.http.url.Url;
import com.kickbox.java.model.ExtendedKickBoxResponse;
import com.kickbox.java.model.KickBoxResponse;
import com.kickbox.java.model.Result;

/**
 * The Java API for the <a href="http://docs.kickbox.io/docs/using-the-api">Kickbox.io</a> service.
 * Can be used for easy verification of the emails in the java projects.
 *
 * @author szagriichuk.
 */
public class KickBoxApi extends BaseHttpApi {
    public KickBoxApi(String key) {
        super(key);
    }

    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid and deliverable in other case
     * returns {@code false}.
     */
    public boolean verify(String email) {
        return verify(email, null);

    }

    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid and deliverable in other case
     * returns {@code false}.
     * <p>
     * The {@code timeout} is maximum time, in milliseconds, for the API to complete a verification request.
     * If it is {@code null} will be used default value is 6000 ms.
     */
    public boolean verify(String email, Long timeout) {
        KickBoxResponse response = verifyWithResponse(email, timeout);
        return Result.DELIVERABLE.getValue().equals(response.result);
    }

    /**
     * Verifies the input {@code email} and returns new instance of {@link ExtendedKickBoxResponse} which contains
     * full description of the verification.
     */
    public ExtendedKickBoxResponse verifyWithResponse(String email) {
        return verifyWithResponse(email, null);
    }


    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid and deliverable in other case
     * returns {@code false}.
     * <p>
     * The {@code timeout} is maximum time, in milliseconds, for the API to complete a verification request.
     * If it is {@code null} will be used default value is 6000 ms.
     */
    public ExtendedKickBoxResponse verifyWithResponse(String email, Long timeout) {
        ExtendedKickBoxResponse response;
        if (timeout != null) {
            response = get(Url.verifyV2().build(), new Email(email), new Timeout(timeout));
        } else {
            response = get(Url.verifyV2().build(), new Email(email));
        }
        return response;
    }
}
