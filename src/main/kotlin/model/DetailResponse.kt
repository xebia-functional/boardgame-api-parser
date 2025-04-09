package com.es.model

import com.es.model.detail.BGGGameDetailItem
import nl.adaptivity.xmlutil.serialization.XmlElement
import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    @XmlElement(true) // Para manejar el wrapper XML
    val items: List<BGGGameDetailItem> = emptyList()
)
