package fr.epsi.Nguyen_Vitry.rickandmorty

import android.os.Bundle
import android.view.View
import android.widget.TextView
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
        val errorTextView: TextView = findViewById(R.id.errorTextView)

        viewModel.characters.observe(this, Observer { characters ->
            recyclerView.adapter = CharactersAdapter(characters)
            recyclerView.visibility = View.VISIBLE
            errorTextView.visibility = View.GONE
        })

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) {
                errorTextView.text = errorMessage
                recyclerView.visibility = View.GONE
                errorTextView.visibility = View.VISIBLE
            }
        })

        viewModel.getCharacters(1)
    }
}
