package com.kiteaio.captcha.webapp.controllers;

import com.google.gson.JsonObject;
import com.kiteaio.captcha.Context;
import com.kiteaio.captcha.models.CaptchaToken;
import com.kiteaio.captcha.models.CaptchaWindow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
@Controller
public class MainController {

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("siteKey", Context.getSiteKey());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addNewToken(@RequestBody JsonObject jsonObject) {
        final JsonObject responseObject = new JsonObject();
        HttpStatus httpStatus = HttpStatus.OK;

        if(jsonObject.has("recaptcha_token") && jsonObject.has("uuid")) {
            final CaptchaWindow captchaWindow = Context.getWindow(jsonObject.get("uuid").getAsString());
            if(captchaWindow != null) {
                final CaptchaToken captchaToken = new CaptchaToken(jsonObject.get("recaptcha_token").getAsString(), Instant.now().getEpochSecond());

                captchaWindow.addToken(captchaToken);

                responseObject.addProperty("status", true);
                responseObject.addProperty("message", "Added captcha");

                captchaWindow.close();
            } else {
                responseObject.addProperty("status", false);
                responseObject.addProperty("message", "Window turned up null");
            }
        } else {
            responseObject.addProperty("status", false);
            responseObject.addProperty("message", "Malformed object");
        }

        return ResponseEntity
                .status(httpStatus)
                .header("Content-Type", "application/json")
                .body(responseObject.toString());
    }



}
