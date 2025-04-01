package com.es.controller

import com.es.service.BGGService
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.application.Application

fun Route.bgg(application: Application) {
    val bggService = BGGService(application.environment.config)

    get("/search") {
        val query = call.request.queryParameters["query"] ?: throw BadRequestException("Query can not be empty")
        val exact = call.request.queryParameters["exact"]?.toIntOrNull()

        if (exact != null && exact != 1) {
            throw BadRequestException("exact can only be null or 1")
        }

        call.respond(bggService.searchGames(query, exact))
    }

    get("/details") {
        val id = call.request.queryParameters["id"] ?: throw BadRequestException("Id can not be empty")

        if (id.isBlank()) {
            throw BadRequestException("Id can not be empty")
        }

        if (id.toIntOrNull() == null || id.toIntOrNull()!! < 0) {
            throw BadRequestException("Id must be a number")
        }

        call.respond(bggService.getGameDetails(id))
    }
}
