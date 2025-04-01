package com.es.service

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class BGGService {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
        }
    }

    suspend fun searchGames(query: String, exact: Int?): String {
        try {
            val url = buildString {
                append("https://boardgamegeek.com/xmlapi2/search?")
                append("query=$query")
                exact?.let { append("&exact=$it") }
            }

            val response: HttpResponse = client.get(url)

            val responseBody = response.bodyAsText()

            return responseBody
        } catch (e: Exception) {
            throw RuntimeException("Error in BoardGameGeek API: $e")
        }
    }

    suspend fun getGameDetails(id: String): String {
        return "details"
    }
}