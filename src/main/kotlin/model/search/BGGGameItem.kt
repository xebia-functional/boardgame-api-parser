package com.es.model.search

import com.es.model.BGGPropertyValue
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class BGGGameItem(
    @XmlElement(true)
    val id: String? = null,

    @XmlElement(false)
    val type: String? = null,

    @XmlElement(true)
    val name: BGGGameItemName? = null,

    @XmlElement(true)
    val yearpublished: BGGPropertyValue? = null,

    @XmlElement(false)
    val value: String? = null
)
