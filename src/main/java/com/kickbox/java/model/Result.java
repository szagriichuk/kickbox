package com.kickbox.java.model;

/**
 * @author szagriichuk.
 */
public enum Result {
    DELIVERABLE("deliverable"), UNDELIVERABLE("undeliverable"), RISKY("risky"), UNKNOWN("unknown");

    private String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
