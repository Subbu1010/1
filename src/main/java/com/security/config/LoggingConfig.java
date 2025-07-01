package com.security.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class LoggingConfig {

    @Value("${spring.profiles.active:dev}")
    private String activeProfile;

    @PostConstruct
    public void configureLogging() {
        switch (activeProfile.toLowerCase()) {
            case "dev":
                // Development: Set detailed logging
                Configurator.setLevel("com.security", Level.DEBUG);
                Configurator.setLevel("org.springframework", Level.DEBUG);
                Configurator.setLevel("org.hibernate", Level.DEBUG);
                Configurator.setLevel("org.hibernate.SQL", Level.DEBUG);
                break;
                
            case "uat":
                // UAT: Set moderate logging
                Configurator.setLevel("com.security", Level.INFO);
                Configurator.setLevel("org.springframework", Level.INFO);
                Configurator.setLevel("org.hibernate", Level.WARN);
                Configurator.setLevel("org.hibernate.SQL", Level.INFO);
                break;
                
            case "prod":
                // Production: Set minimal logging
                Configurator.setLevel("com.security", Level.WARN);
                Configurator.setLevel("org.springframework", Level.WARN);
                Configurator.setLevel("org.hibernate", Level.ERROR);
                Configurator.setLevel("org.hibernate.SQL", Level.OFF);
                break;
                
            default:
                // Default to INFO level
                Configurator.setLevel("com.security", Level.INFO);
                Configurator.setLevel("org.springframework", Level.INFO);
                Configurator.setLevel("org.hibernate", Level.WARN);
                break;
        }
    }
} 