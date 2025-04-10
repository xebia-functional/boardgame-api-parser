package com.es.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class BGGPropertyValue(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null,
)
