package com.myftiu.digital.river;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by myftiu
 */


@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages ={ "com.myftiu.digital.river" })
public class MainHost {

    private static final Logger logger = LoggerFactory.getLogger(MainHost.class);

    public static void main(String[] args) throws Exception
    {
        SpringApplication springApplication = new SpringApplication(MainHost.class);
        logger.info("Server is starting");
        springApplication.run(args);
    }
}
