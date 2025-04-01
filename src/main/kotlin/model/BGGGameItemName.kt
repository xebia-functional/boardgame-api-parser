package com.es.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class BGGGameItemName(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("type")
    val type: String? = null,

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null
)