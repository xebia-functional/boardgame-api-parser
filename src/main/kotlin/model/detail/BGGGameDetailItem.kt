package com.es.model.detail

import com.es.model.BGGPropertyValue
import com.es.model.search.BGGGameItemName
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BGGGameDetailItem(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("id")
    val id: String,
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("type")
    val type: String,
    @JacksonXmlProperty(localName = "thumbnail")
    @JsonProperty("thumbnail")
    val thumbnail: String? = null,
    @JacksonXmlProperty(localName = "image")
    @JsonProperty("image")
    val image: String? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "name")
    @JsonProperty("names")
    val names: List<BGGGameItemName>? = null,
    @JacksonXmlProperty(localName = "description")
    @JsonProperty("description")
    val description: String? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "yearpublished")
    @JsonProperty("yearpublished")
    val yearPublished: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "minplayers")
    @JsonProperty("minplayers")
    val minPlayers: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "maxplayers")
    @JsonProperty("maxplayers")
    val maxPlayers: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "playingtime")
    @JsonProperty("playingtime")
    val playingTime: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "minplaytime")
    @JsonProperty("minplaytime")
    val minPlayTime: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "maxplaytime")
    @JsonProperty("maxplaytime")
    val maxPlayTime: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "minage")
    @JsonProperty("minage")
    val minAge: BGGPropertyValue? = null,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "link")
    @JsonProperty("links")
    val links: List<BGGGameDetailLink>? = null,
)
