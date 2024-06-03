package fr.epsi.Nguyen_Vitry.rickandmorty.repository

import fr.epsi.Nguyen_Vitry.rickandmorty.model.CharacterResponse
import fr.epsi.Nguyen_Vitry.rickandmorty.network.RickAndMortyApiService

class CharacterRepository(private val apiService: RickAndMortyApiService) {
    suspend fun getCharacters(page: Int): CharacterResponse {
        return apiService.getCharacters(page)
    }
}