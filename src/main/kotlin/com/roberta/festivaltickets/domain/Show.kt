package com.roberta.festivaltickets.domain

import java.time.LocalDate
import java.time.LocalTime

data class Show(
    val id: String,
    val name: String,
    val date: LocalDate,
    val time: LocalTime?,
    val venueName: String,
    val state: String?,
    val ticketUrl: String,
)