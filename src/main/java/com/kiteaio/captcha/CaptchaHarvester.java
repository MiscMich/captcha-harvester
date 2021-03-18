package com.kiteaio.captcha;

import com.kiteaio.captcha.models.CaptchaWindow;
import com.kiteaio.captcha.webapp.WebAPP;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class CaptchaHarvester {
    private String domain, siteKey;

    public CaptchaHarvester(String domain, String siteKey) {
        this.domain = domain;
        this.siteKey = siteKey;

        Context.setSiteKey(siteKey);

        new WebAPP().start();
    }

    /**
     * Creates a new Captcha window
     * @return new CaptchaWindow object
     */
    public CaptchaWindow createWindow() {
        System.setProperty("java.awt.headless", "false");

        final JFrame frame = new JFrame("KiteAIO Harvester");

        final JFXPanel jfxPanel = new JFXPanel();

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(360, 550);
        frame.add(jfxPanel);


        Platform.runLater(() -> {
            final WebView webView = new WebView();
            final WebEngine engine = webView.getEngine();

            jfxPanel.setScene(new Scene(webView));
            engine.load("https://kith.com/checkpoint");
        });

        frame.setVisible(true);

        return new CaptchaWindow(frame, getDomain(), getSiteKey());
    }

    public String getDomain() {
        return domain;
    }

    public String getSiteKey() {
        return siteKey;
    }
}
