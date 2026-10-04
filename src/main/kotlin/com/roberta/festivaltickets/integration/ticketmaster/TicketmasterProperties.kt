package com.roberta.festivaltickets.integration.ticketmaster
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ticketmaster")
data class TicketmasterProperties(
    val apiKey: String,
    val baseUrl: String,
    )