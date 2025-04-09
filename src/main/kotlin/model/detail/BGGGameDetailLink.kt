package com.es.model.detail

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BGGGameDetailLink(
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("type")
    val type: String? = null,

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("id")
    val id: String? = null,

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("value")
    val value: String? = null
)
