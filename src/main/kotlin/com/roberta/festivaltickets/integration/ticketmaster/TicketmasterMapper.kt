package com.roberta.festivaltickets.integration.ticketmaster
import com.fasterxml.jackson.annotation.JsonProperty
import com.roberta.festivaltickets.domain.Show
import java.time.LocalDate
import java.time.LocalTime

fun TicketmasterEvent.toShow(): Show? {
    val eventId = id ?: return null
    val eventName = name?: return null
    val eventDate = dates?.start?.localDate?.let{ LocalDate.parse(it) } ?: return null
    val eventTime = dates.start?.localTime?.let { LocalTime.parse(it) }
    val venue = embedded?.venues?.firstOrNull()
    val venueName = venue?.name?: return null
    val state = venue.state?.stateCode
    val ticketUrl = url?: return null

    return Show(
        id = eventId,
        name = eventName,
        date = eventDate,
        time = eventTime,
        venueName = venueName,
        state = state,
        ticketUrl = ticketUrl,
    )
}
