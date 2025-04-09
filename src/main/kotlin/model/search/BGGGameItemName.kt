package com.es.model.search

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class BGGGameItemName(
    @XmlElement(false)
    val type: String? = null,

    @XmlElement(false)
    val value: String? = null
)
