package fr.epsi.Nguyen_Vitry.rickandmorty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.Nguyen_Vitry.rickandmorty.network.RickAndMortyApiService
import fr.epsi.Nguyen_Vitry.rickandmorty.repository.CharacterRepository
import fr.epsi.Nguyen_Vitry.rickandmorty.viewmodel.CharactersListViewModel
import fr.epsi.Nguyen_Vitry.rickandmorty.viewmodel.CharactersListViewModelFactory

class CharactersListActivity : AppCompatActivity() {

    private val viewModel: CharactersListViewModel by viewModels {
        CharactersListViewModelFactory(CharacterRepository(RickAndMortyApiService.create()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getCharacters(1).observe(this, Observer { characters ->
            recyclerView.adapter = CharactersAdapter(characters)
        })
    }
}
