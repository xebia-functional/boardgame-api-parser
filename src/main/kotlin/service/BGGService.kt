package com.es.service

import com.es.model.DetailResponse
import com.es.model.SearchResponse
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.config.*

class BGGService(private val config: ApplicationConfig) {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {}
    }

    private val xmlMapper = XmlMapper()
    private val baseUrl = config.propertyOrNull("ktor.externalApi.bggUrl")?.getString() ?: "https://boardgamegeek.com/xmlapi2/"
    suspend fun searchGames(query: String, exact: Int?): SearchResponse {
        try {
            val url = buildString {
                append(baseUrl)
                append("search?")
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

    suspend fun getGameDetails(id: String): DetailResponse {
        try {
            val url = buildString {
                append(baseUrl)
                append("thing?")
                append("id=${id}")
            }

            val response: HttpResponse = client.get(url)

            val responseBody = response.bodyAsText()

            return xmlMapper.readValue(responseBody, DetailResponse::class.java)
        } catch (e: Exception) {
            throw RuntimeException("Error in BoardGameGeek API: $e")
        }
    }
}
