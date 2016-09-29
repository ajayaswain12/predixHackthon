package com.techm.predix.aveoaero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages=("com.techm.predix.aveoaero.entity"))
@EnableJpaRepositories("com.techm.predix.aveoaero.repository")
public class FlightDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightDataServiceApplication.class, args);
    }
}