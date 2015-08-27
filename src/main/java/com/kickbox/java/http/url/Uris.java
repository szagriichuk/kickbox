package com.kickbox.java.http.url;

/**
 * Uris of the kickbox api.
 *
 * @author szagriichuk.
 */
public enum Uris {
    API("https://api.kickbox.io/"), VERIFY("verify"), V2("v2");

    private String value;

    Uris(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

}
