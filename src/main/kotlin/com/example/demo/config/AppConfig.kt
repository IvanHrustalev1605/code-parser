package com.example.demo.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class AppConfig {
    @Bean
    fun jackson() : ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.registerKotlinModule()
        return objectMapper
    }
    @Bean
    fun restTemplate() : RestTemplate {
        return RestTemplate()
    }
}