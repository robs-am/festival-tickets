package com.roberta.festivaltickets.integration.ticketmaster
import org.springframework.boot.context.properties.ConfigurationProperties

data class TicketmasterProperties(
    val apiKey: String,
    val baseUrl: String,
    )