package com.es

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    private val objectMapper = jacksonObjectMapper()


    @Test
    fun `test searchGames endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/search?query=Monopoly&exact=1").apply {
            println("Response status: $status")
            val responseBody = bodyAsText()
            println("Response body: $responseBody")

            assertEquals(HttpStatusCode.OK, status)

            val jsonResponse = objectMapper.readTree(responseBody)
            assertTrue(jsonResponse.has("items"))

            val items = jsonResponse["items"]
            assertTrue(items.size() >= 3)

            val firstGame = items[0]
            assertEquals("1406", firstGame["id"].asText())
            assertEquals("Monopoly", firstGame["name"]["value"].asText())
            assertEquals("1935", firstGame["yearpublished"]["value"].asText())

            val secondGame = items[1]
            assertEquals("17250", secondGame["id"].asText())
            assertEquals("Monopoly", secondGame["name"]["value"].asText())
            assertEquals("1972", secondGame["yearpublished"]["value"].asText())

            val thirdGame = items[2]
            assertEquals("36611", thirdGame["id"].asText())
            assertEquals("Monopoly", thirdGame["name"]["value"].asText())
            assertEquals("1994", thirdGame["yearpublished"]["value"].asText())
        }
    }

    @Test
    fun `test getGameDetails endpoint`() = testApplication {
        application {
            module()
        }
        client.get("/details?id=5433").apply {
            println("Response status: $status")
            val responseBody = bodyAsText()
            println("Response body: $responseBody")

            assertEquals(HttpStatusCode.OK, status)

            val jsonResponse = objectMapper.readTree(responseBody)
            assertTrue(jsonResponse.has("items"))
            val items = jsonResponse["items"]
            assertTrue(items.size() == 1)

            val game = items[0]
            assertEquals("5433", game["id"].asText())

            val names = game["names"]
            val primaryName = names.find { it["type"].asText() == "primary" }
            assertNotNull(primaryName)
            assertEquals("The Crocodile Hunter Game", primaryName?.get("value")?.asText() ?: "")

            assertTrue(game["description"].asText().isNotEmpty())

            assertEquals("1994", game["yearpublished"]["value"].asText())

            assertEquals("2", game["minplayers"]["value"].asText())

            assertEquals("4", game["maxplayers"]["value"].asText())

            assertEquals("30", game["playingtime"]["value"].asText())

            assertEquals("30", game["minplaytime"]["value"].asText())

            assertEquals("30", game["maxplaytime"]["value"].asText())

            assertEquals("5", game["minage"]["value"].asText())

            val links = game["links"]

            assertTrue(links.isArray)
            assertTrue(links.any { it["type"].asText() == "boardgamecategory" })
            assertTrue(links.any { it["type"].asText() == "boardgamemechanic" })
            assertTrue(links.any { it["type"].asText() == "boardgamefamily" })

            assertNotNull(game["thumbnail"].asText())
            assertNotNull(game["image"].asText())
        }
    }


}
