package com.es.controller

import com.es.service.BGGService
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.bgg() {
    val bggService = BGGService()

    get("/search") {
        call.respondText(bggService.searchGames("test", 1))
    }

    get("/details") {
        call.respondText(bggService.getGameDetails("1"))
    }
}
