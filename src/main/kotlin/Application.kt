package com.es

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.plugins.cors.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "Error 500: $cause", status = HttpStatusCode.InternalServerError)
        }

        exception<BadRequestException> { call, cause ->
            call.respondText(text = "Error 400: ${cause.message}", status = HttpStatusCode.BadRequest)
        }
    }

    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.Authorization)
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
    }

    configureRouting()
}
