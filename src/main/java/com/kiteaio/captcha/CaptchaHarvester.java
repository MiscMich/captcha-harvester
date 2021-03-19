package com.kiteaio.captcha;

import com.kiteaio.captcha.models.CaptchaWindow;
import com.kiteaio.captcha.webapp.WebAPP;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.UUID;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class CaptchaHarvester {
    private final String domain, siteKey;

    public CaptchaHarvester(String domain, String siteKey, int port) {
        this.domain = domain;
        this.siteKey = siteKey;

        Context.setSiteKey(siteKey);
        Context.setPORT(port);

        new WebAPP().start();
    }

    public CaptchaHarvester(String domain, String siteKey) {
        this.domain = domain;
        this.siteKey = siteKey;

        Context.setSiteKey(siteKey);

        new WebAPP().start();
    }

    public CaptchaWindow createWindow() {
        return createWindow(true);
    }

    /**
     * Creates a new Captcha window
     * @return new CaptchaWindow object
     */
    public CaptchaWindow createWindow(boolean show) {
        System.setProperty("java.awt.headless", "false");

        final String uuid = UUID.randomUUID().toString();
        final JFrame frame = new JFrame("KiteAIO Harvester");

        final JFXPanel jfxPanel = new JFXPanel();

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(330, 160);
        frame.add(jfxPanel);
        frame.setResizable(false);

        Platform.runLater(() -> {
            final WebView webView = new WebView();
            final WebEngine engine = webView.getEngine();

            jfxPanel.setScene(new Scene(webView));
            engine.load(String.format("http://127.0.0.1:%s/?uuid=%s", Context.getPORT(), uuid));
        });

        if(show) {
            frame.setVisible(true);
        }

        final CaptchaWindow captchaWindow = new CaptchaWindow(frame, getDomain(), getSiteKey(), uuid);

        Context.addWindow(captchaWindow);

        return captchaWindow;
    }

    public String getDomain() {
        return domain;
    }

    public String getSiteKey() {
        return siteKey;
    }
}
