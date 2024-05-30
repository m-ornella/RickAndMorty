import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.nguyen_vitry.rickandmorty.R
import fr.epsi.nguyen_vitry.rickandmorty.adapter.ItemAdapter
import fr.epsi.nguyen_vitry.rickandmorty.network.RickAndMortyApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemAdapter = ItemAdapter(this, listOf()) // Initialize adapter with empty list
        recyclerView.adapter = itemAdapter

        // Fetch character names from the API using coroutines
        fetchCharacterNames()
    }

    private fun fetchCharacterNames() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val characterNames = RickAndMortyApiService.retrofitService.getCharacters()
                withContext(Dispatchers.Main) {
                    // Update RecyclerView with character names
                    itemAdapter.updateData(characterNames)
                }
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
