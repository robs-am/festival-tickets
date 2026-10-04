package com.roberta.festivaltickets

import com.roberta.festivaltickets.integration.ticketmaster.TicketmasterClient
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TicketmasterSmokeTest(
    private val client: TicketmasterClient
) : CommandLineRunner {

    override fun run(vararg args: String) {
        val response = client.searchEvents("Lagum")
        val events = response?.embedded?.events.orEmpty()

        println("Total de eventos: ${response?.page?.totalElements}")

        events.forEach { event ->
            val venue = event.embedded?.venues?.firstOrNull()?.name
            println("${event.dates?.start?.localDate} - ${event.name} - $venue")
        }
    }
}
