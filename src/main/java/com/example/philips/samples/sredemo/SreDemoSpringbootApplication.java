package com.example.philips.samples.sredemo;

import com.example.philips.samples.sredemo.config.SreDemoAppContextInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableJpaRepositories
public class SreDemoSpringbootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SreDemoSpringbootApplication.class)
                .initializers(new SreDemoAppContextInitializer())
                .build()
                .run(args);
    }

}
