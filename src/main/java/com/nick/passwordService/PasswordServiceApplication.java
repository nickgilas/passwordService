package com.nick.passwordService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@ComponentScan("com.nick")
public class PasswordServiceApplication {
    
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigIn() {
  	return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
	SpringApplication.run(PasswordServiceApplication.class, args);
    }
}
