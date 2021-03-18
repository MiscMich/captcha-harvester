package com.kiteaio.captcha;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class Context {
    private static String siteKey;

    public static void setSiteKey(String siteKey) {
        Context.siteKey = siteKey;
    }

    public static String getSiteKey() {
        return siteKey;
    }
}
