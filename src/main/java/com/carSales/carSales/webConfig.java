package com.carSales.carSales; // Ajuste para o seu pacote

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "http://127.0.0.1:5500") // Ajuste para o domínio do frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}

