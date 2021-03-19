package com.kiteaio.captcha.models;

import org.openqa.selenium.json.Json;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class CaptchaWindow {
    private final JFrame jFrame;
    private final String domain, siteKey, uuid;

    private final List<CaptchaToken> captchaTokens = new LinkedList<>();

    public CaptchaWindow(JFrame jFrame, String domain, String siteKey, String uuid) {
        this.jFrame = jFrame;
        this.domain = domain;
        this.siteKey = siteKey;
        this.uuid = uuid;
    }

    public void close() {
        jFrame.setVisible(false);
    }

    public String getUuid() {
        return uuid;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public String getDomain() {
        return domain;
    }

    public JFrame getJFrame() {
        return jFrame;
    }

    public void addToken(CaptchaToken captchaToken) {
        this.captchaTokens.add(captchaToken);
    }

    public List<CaptchaToken> getCaptchaTokens() {
        return captchaTokens;
    }
}
