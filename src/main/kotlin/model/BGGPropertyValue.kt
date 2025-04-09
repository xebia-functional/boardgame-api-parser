package com.es.model

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class BGGPropertyValue(
    @XmlElement(false)
    val value: String? = null
)
