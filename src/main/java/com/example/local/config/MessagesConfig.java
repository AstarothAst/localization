package com.example.local.config;

import com.example.local.msg.MyMessageSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class LocaleConfig {

    @Bean
    public MessageSource messageSource() {
        return new MyMessageSource();
    }
}
