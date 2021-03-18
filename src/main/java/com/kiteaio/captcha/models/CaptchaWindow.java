package com.kiteaio.captcha.models;

import org.openqa.selenium.json.Json;

import javax.swing.*;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class CaptchaWindow {
    private final JFrame jFrame;
    private final String domain, siteKey;

    public CaptchaWindow(JFrame jFrame, String domain, String siteKey) {
        this.jFrame = jFrame;
        this.domain = domain;
        this.siteKey = siteKey;
    }

    public void close() {
        jFrame.setVisible(false);
    }

    public String getSiteKey() {
        return siteKey;
    }

    public String getDomain() {
        return domain;
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
