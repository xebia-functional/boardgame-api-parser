package com.es.model.search

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class BGGGameItemYearPublished(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null
)