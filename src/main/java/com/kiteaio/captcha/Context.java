package com.kiteaio.captcha;

import com.kiteaio.captcha.models.CaptchaWindow;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class Context {
    private static String SITE_KEY;
    private static int PORT = 8080;

    private static final List<CaptchaWindow> WINDOWS = new LinkedList<>();

    public static void addWindow(CaptchaWindow window) {
        WINDOWS.add(window);
    }

    public static CaptchaWindow getWindow(String uuid) {
        for(CaptchaWindow captchaWindow : getWindows()) {
            if(captchaWindow.getUuid().equalsIgnoreCase(uuid))
                return captchaWindow;
        }

        return null;
    }

    public static List<CaptchaWindow> getWindows() {
        return WINDOWS;
    }

    public static void setSiteKey(String siteKey) {
        Context.SITE_KEY = siteKey;
    }

    public static void setPORT(int PORT) {
        Context.PORT = PORT;
    }

    public static int getPORT() {
        return PORT;
    }

    public static String getSiteKey() {
        return SITE_KEY;
    }
}
