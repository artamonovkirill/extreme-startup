package com.github.artamonovkirill

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.test.web.reactive.server.WebTestClient

/**
 * Excludes WebTestClient, since GOJI HTTP Client is user instead
 */
class NoWebClient {
    @Bean
    @Primary
    WebTestClient webTestClient() {
        null
    }
}
