package com.example.philips.samples.sredemo.config;

import io.pivotal.cfenv.core.CfEnv;
import io.pivotal.cfenv.core.CfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SreDemoAppContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static Logger log = LoggerFactory.getLogger(SreDemoAppContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        log.info("Initialising application context");

        ConfigurableEnvironment appEnvironment = applicationContext.getEnvironment();

        CfEnv cfEnv = new CfEnv();

        List<String> profiles = new ArrayList<>();

        List<CfService> services = cfEnv.findAllServices();
        List<String> serviceNames = services.stream()
                .map(CfService::getName)
                .collect(Collectors.toList());

        services.forEach(cfService -> log.info("Service -> {}, {}, {}", cfService.getName(),
                        StringUtils.collectionToCommaDelimitedString(cfService.getTags()),
                        cfService.createCredentials().getMap()
                )
        );

        log.info("Found services: {}", StringUtils.collectionToCommaDelimitedString(serviceNames));


        for (CfService service : services) {
            log.info("Service: {}, tags: {}", service.getName(),
                    StringUtils.collectionToCommaDelimitedString(service.getTags())
            );
        }
    }
}
