
package com.roberta.festivaltickets.integration.ticketmaster
import com.fasterxml.jackson.annotation.JsonProperty

data class TicketmasterVenue(
    val name: String?,
    val city: TicketmasterCity?,
    val state: TicketmasterState?,
    val location: TicketmasterLocation?
)

data class TicketmasterCity(
    val name: String?
)

data class TicketmasterState(
    val stateCode: String?
)

data class TicketmasterLocation(
    val latitude: String?,
    val longitude: String?
)

data class TicketmasterAttraction(
    val name: String?,
    val id: String?
)

data class TicketmasterStart(
    val localDate: String?,
    val localTime: String?,
)

data class TicketmasterDates(
    val start: TicketmasterStart?
)

data class TicketmasterClassifications(
    val genre: TicketmasterNamedItem?,
    val subGenre: TicketmasterNamedItem?
)

data class TicketmasterNamedItem(
    val name: String?
)

data class TicketmasterEvent (
    val id: String?,
    val name: String?,
    val dates: TicketmasterDates?,
    val url: String?,
    val classifications: List<TicketmasterClassifications>?,
    @JsonProperty("_embedded")
    val embedded:TicketmasterEventRelations?
)

data class TicketmasterEventRelations(
    val venues: List<TicketmasterVenue>?,
    val attractions: List<TicketmasterAttraction>?
)


data class TicketmasterEventsEmbedded(
    val events: List<TicketmasterEvent>?
)

data class TicketmasterPage(
    val size: Int?,
    val totalElements: Int?,
    val totalPages: Int?,
    val number: Int?
)

data class TicketmasterEventsResponse(
    @JsonProperty("_embedded")
    val embedded: TicketmasterEventsEmbedded?,
    val page: TicketmasterPage?
)
