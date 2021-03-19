package com.kiteaio.captcha.webapp;

import com.kiteaio.captcha.Context;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Brennan
 * @since 3/19/2021
 **/
@Configuration
public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory){
        factory.setPort(Context.getPORT());
    }
}