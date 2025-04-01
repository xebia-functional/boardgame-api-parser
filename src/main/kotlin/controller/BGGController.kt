package com.es.controller

import com.es.service.BGGService
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.bgg() {
    val bggService = BGGService()

    get("/search") {
        val query = call.request.queryParameters["query"] ?: throw BadRequestException("Query can not be empty")
        val exact = call.request.queryParameters["exact"]?.toIntOrNull()

        if (exact != null && exact != 1) {
            throw BadRequestException("exact can only be null or 1")
        }

        call.respondText(bggService.searchGames(query, exact))
    }

    get("/details") {
        call.respondText(bggService.getGameDetails("1"))
    }
}
