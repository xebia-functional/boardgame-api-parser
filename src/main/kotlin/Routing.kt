package com.es

import com.es.controller.bgg
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(ContentNegotiation) {
        jackson {
            registerKotlinModule()
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        bgg()
    }
}
