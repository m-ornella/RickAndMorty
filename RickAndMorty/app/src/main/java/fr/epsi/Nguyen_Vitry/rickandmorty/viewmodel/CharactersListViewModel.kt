package fr.epsi.Nguyen_Vitry.rickandmorty.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import fr.epsi.Nguyen_Vitry.rickandmorty.repository.CharacterRepository
import fr.epsi.Nguyen_Vitry.rickandmorty.model.Character

class CharactersListViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun getCharacters(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getCharacters(page)
                _characters.postValue(response.results)
                _errorMessage.postValue(null)
            } catch (e: Exception) {
                _errorMessage.postValue("Failed to load characters: ${e.message}")
            }
        }
    }
}
