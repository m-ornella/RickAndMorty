package fr.epsi.Nguyen_Vitry.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import fr.epsi.Nguyen_Vitry.rickandmorty.repository.CharacterRepository

class CharactersListViewModel(private val repository: CharacterRepository) : ViewModel() {
    fun getCharacters(page: Int) = liveData(Dispatchers.IO) {
        val response = repository.getCharacters(page)
        emit(response.results)
    }
}