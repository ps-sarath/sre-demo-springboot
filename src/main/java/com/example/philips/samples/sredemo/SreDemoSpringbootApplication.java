package com.example.philips.samples.sredemo;

import com.example.philips.samples.sredemo.config.SreDemoAppContextInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SreDemoSpringbootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SreDemoSpringbootApplication.class)
                .initializers(new SreDemoAppContextInitializer())
                .application()
                .run();
    }

}
