package com.example.philips.samples.sredemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SreDemoAppContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static Logger log = LoggerFactory.getLogger(SreDemoAppContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        log.info("Initialising application context");

    }
}
