package com.roberta.festivaltickets

import com.roberta.festivaltickets.integration.ticketmaster.TicketmasterClient
import com.roberta.festivaltickets.integration.ticketmaster.toShow
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TicketmasterSmokeTest(
    private val client: TicketmasterClient
) : CommandLineRunner {

    override fun run(vararg args: String) {
        val response = client.searchEvents("Lagum")
        val shows = response?.embedded?.events.orEmpty()
            .mapNotNull { it.toShow() }
            .sortedBy { it.date }

        shows.forEach { show ->
            println("${show.date} ${show.time} - ${show.name} - ${show.venueName} (${show.state})")
        }
    }
}
