package com.example.philips.samples.sredemo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class CloudConfig {

    private static Logger log = LoggerFactory.getLogger(CloudConfig.class);

    @Value("${vcap.services.sre-demo-db.credentials.username:''}")
    String username;

    @Value("${vcap.services.sre-demo-db.credentials.password:''}")
    String password;

    @Value("${vcap.services.sre-demo-db.credentials.hostname:''}")
    String hostname;

    @Value("${vcap.services.sre-demo-db.credentials.port:''}")
    String port;

    @Value("${vcap.services.sre-demo-db.credentials.db_name:''}")
    String dbName;


    @Bean
    public DataSource cloudDatasource() {
        String url = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName;
        log.info("Connecting to {} as {}", url, username);

        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(config);
    }
}
