package com.kickbox.java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author szagriichuk.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KickBoxResponse {
    public String result;
    public String reason;
    public boolean role;
    public boolean free;
    public boolean disposable;
    public boolean accept_all;
    public String did_you_mean;
    public double sendex;
    public String email;
    public String user;
    public String domain;
    public boolean success;

    @Override
    public String toString() {
        return "KickBoxResponse{" +
                "result='" + result + '\'' +
                ", reason='" + reason + '\'' +
                ", role=" + role +
                ", free=" + free +
                ", disposable=" + disposable +
                ", accept_all=" + accept_all +
                ", did_you_mean='" + did_you_mean + '\'' +
                ", sendex=" + sendex +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                ", domain='" + domain + '\'' +
                ", success=" + success +
                '}';
    }
}
