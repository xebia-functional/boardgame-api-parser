package com.es

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "Error 500: $cause" , status = HttpStatusCode.InternalServerError)
        }

        exception<BadRequestException> { call, cause ->
            call.respondText(text = "Error 400: ${cause.message}", status = HttpStatusCode.BadRequest)
        }
    }

    configureRouting()
}