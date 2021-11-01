package com.example.springspocktrial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class Config {

    @Bean
    @Primary
    ISampleService2 sampleService2() {
        return new SampleService2();
    }
}
