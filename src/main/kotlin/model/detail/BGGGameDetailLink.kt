package com.es.model.detail

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class BGGGameDetailLink(
    @XmlElement(true)
    val type: String? = null,

    @XmlElement(true)
    val id: String? = null,

    @XmlElement(true)
    val value: String? = null
)
