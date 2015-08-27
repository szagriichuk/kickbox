package com.kickbox.java;

/**
 * @author szagriichuk.
 */
public class KickBoxApiException extends RuntimeException {
    public KickBoxApiException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
