package com.kiteaio.captcha.models;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class CaptchaToken {
    private final String token;

    private final long timestamp;

    public CaptchaToken(String token, long timestamp) {
        this.token = token;
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return timestamp;
    }
}


