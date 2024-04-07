package com.example.demotinkoffapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.piapi.core.InvestApi;


@Configuration
public class ApplicationConfig {
    @Bean
    public InvestApi invApi(){
        String token = System.getenv("ssoToken");
        return InvestApi.create(token);
    }

}
