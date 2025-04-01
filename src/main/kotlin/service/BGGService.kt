package com.es.service

import com.es.model.SearchResponse
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class BGGService {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {}
    }

    private val xmlMapper = XmlMapper()

    suspend fun searchGames(query: String, exact: Int?): SearchResponse {
        try {
            val url = buildString {
                append("https://boardgamegeek.com/xmlapi2/search?")
                append("query=$query")
                append("&type=boardgame")
                append("&exact=${exact ?: 0}")
            }

            val response: HttpResponse = client.get(url)

            val responseBody = response.bodyAsText()

            return xmlMapper.readValue(responseBody, SearchResponse::class.java)
        } catch (e: Exception) {
            throw RuntimeException("Error in BoardGameGeek API: $e")
        }
    }

    suspend fun getGameDetails(id: String): String {
        return "details"
    }
}