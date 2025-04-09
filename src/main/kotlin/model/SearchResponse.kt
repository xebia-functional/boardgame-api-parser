package com.es.model

import com.es.model.search.BGGGameItem
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.*

@Serializable
@XmlSerialName("items", "", "")
data class SearchResponse(
    @XmlElement(false)
    val total: Int? = null,

    @XmlElement(false)
    val termsofuse: String? = null,

    @XmlChildrenName("items")
    val item: List<BGGGameItem> = emptyList()
)
