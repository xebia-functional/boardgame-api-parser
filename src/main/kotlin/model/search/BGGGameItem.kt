package com.es.model.search

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper

@JsonIgnoreProperties(ignoreUnknown = true)
data class BGGGameItem(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("id")
    val id: String,

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "name")
    @JsonProperty("name")
    val name: BGGGameItemName? = null,

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "yearpublished")
    @JsonProperty("yearpublished")
    val yearPublished: BGGGameItemYearPublished? = null
)