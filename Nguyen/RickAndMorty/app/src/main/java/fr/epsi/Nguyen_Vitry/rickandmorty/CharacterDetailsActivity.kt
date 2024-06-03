package fr.epsi.Nguyen_Vitry.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import coil.load
import fr.epsi.Nguyen_Vitry.rickandmorty.model.Character

class CharacterDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getParcelableExtra<Character>("character")

        if (character != null) {
            val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)
            supportActionBar?.title = character.name
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            findViewById<TextView>(R.id.nameTextView).text = character.name
            findViewById<TextView>(R.id.statusTextView).text = character.status
            findViewById<TextView>(R.id.speciesTextView).text = character.species
            findViewById<TextView>(R.id.genderTextView).text = character.gender
            findViewById<TextView>(R.id.originTextView).text = character.origin.name
            findViewById<TextView>(R.id.locationTextView).text = character.location.name
            findViewById<ImageView>(R.id.characterImageView).load(character.image)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
