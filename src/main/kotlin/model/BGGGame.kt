package com.es.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper

data class Name(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("type")
    val type: String? = null,

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null
)

data class YearPublished(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class BGGItem(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("id")
    val id: String,

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "name")
    @JsonProperty("name")
    val name: Name? = null,

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "yearpublished")
    @JsonProperty("yearpublished")
    val yearPublished: YearPublished? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResponse(
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    @JsonProperty("items")
    val items: List<BGGItem> = emptyList(),
)