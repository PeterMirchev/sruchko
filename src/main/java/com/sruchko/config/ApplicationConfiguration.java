package com.sruchko.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        JacksonConfiguration.class
})
@Configuration
@EnableConfigurationProperties()
public class ApplicationConfiguration {
}
