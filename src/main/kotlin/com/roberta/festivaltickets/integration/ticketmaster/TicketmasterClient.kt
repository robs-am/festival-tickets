package com.roberta.festivaltickets.integration.ticketmaster

import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class TicketmasterClient(
    private val properties: TicketmasterProperties
) {
    private val restClient = RestClient.create(properties.baseUrl)

    fun searchEvents(keyword: String): TicketmasterEventsResponse? {
        return restClient.get()
            .uri { builder ->
                builder.path("/events.json")
                    .queryParam("keyword", keyword)
                    .queryParam("countryCode", "BR")
                    .queryParam("apikey", properties.apiKey)
                    .build()
            }
            .retrieve()
            .body(TicketmasterEventsResponse::class.java)
    }
}
