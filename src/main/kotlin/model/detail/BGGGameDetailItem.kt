package com.es.model.detail

import com.es.model.search.BGGGameItemName
import com.es.model.BGGPropertyValue
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class BGGGameDetailItem(
    @XmlElement(true) // Atributo XML
    val id: String,

    @XmlElement(true) // Atributo XML
    val type: String,

    @XmlElement
    val thumbnail: String? = null,

    @XmlElement
    val image: String? = null,

    @XmlElement
    val names: List<BGGGameItemName>? = null, // Lista de nombres

    @XmlElement
    val description: String? = null,

    @XmlElement
    val yearPublished: BGGPropertyValue? = null,

    @XmlElement
    val minPlayers: BGGPropertyValue? = null,

    @XmlElement
    val maxPlayers: BGGPropertyValue? = null,

    @XmlElement
    val playingTime: BGGPropertyValue? = null,

    @XmlElement
    val minPlayTime: BGGPropertyValue? = null,

    @XmlElement
    val maxPlayTime: BGGPropertyValue? = null,

    @XmlElement
    val minAge: BGGPropertyValue? = null,

    @XmlElement
    val links: List<BGGGameDetailLink>? = null, // Lista de enlaces
)
