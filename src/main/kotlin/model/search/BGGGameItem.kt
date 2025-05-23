package com.es.model.search

import com.es.model.BGGPropertyValue
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

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
    val yearPublished: BGGPropertyValue? = null,
)
