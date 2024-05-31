package fr.epsi.nguyen_vitry.rickandmorty

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.nguyen_vitry.rickandmorty.adapter.ItemAdapter

class CharactersListActivity : AppCompatActivity() {

        private lateinit var charactersRecyclerView: RecyclerView
        private val viewModel: CharactersListViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_characters_list)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            charactersRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            charactersRecyclerView.layoutManager = LinearLayoutManager(this)
            viewModel.resultLiveData.observe(this) { list ->
                var adapter = ItemAdapter(list)
            }
        }
    }
