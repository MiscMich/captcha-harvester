package com.kiteaio.captcha;

import com.kiteaio.captcha.models.CaptchaToken;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class CaptchaManager {
    private static final List<CaptchaToken> captchaTokens = new LinkedList<>();

    public static void add(CaptchaToken captchaToken) {
        getCaptchaTokens().add(captchaToken);
    }

    public static List<CaptchaToken> getCaptchaTokens() {
        return captchaTokens;
    }
}
