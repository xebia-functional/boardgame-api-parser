package com.es.service

class BGGService {
    suspend fun searchGames(query: String, exact: Int?): String {
        return "search"
    }

    suspend fun getGameDetails(id: String): String {
        return "details"
    }
}