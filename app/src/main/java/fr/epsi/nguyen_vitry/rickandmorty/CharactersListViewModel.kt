package fr.epsi.nguyen_vitry.rickandmorty

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.epsi.nguyen_vitry.rickandmorty.model.Characters
import fr.epsi.nguyen_vitry.rickandmorty.network.RickAndMortyApi
import kotlinx.coroutines.launch
import java.io.IOException

class CharactersListViewModel : ViewModel() {

    var resultLiveData = MutableLiveData<List<Characters>>()
    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                val listResult = RickAndMortyApi.retrofitService.getCharactersName()
                resultLiveData.postValue(listResult)
            } catch (e: IOException) {
                Log.e("Error", e.toString())
            }
        }
    }
}