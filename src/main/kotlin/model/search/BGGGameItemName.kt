package com.es.model.search

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BGGGameItemName(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("type")
    val type: String? = null,

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null
)