package fr.epsi.nguyen_vitry.rickandmorty.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    val id: String,
    @SerialName(value = "name")
    val name: String
)