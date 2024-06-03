package fr.epsi.Nguyen_Vitry.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import fr.epsi.Nguyen_Vitry.rickandmorty.model.Character

class CharacterDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getParcelableExtra<Character>("character")

        if (character != null) {
            findViewById<TextView>(R.id.nameTextView).text = character.name
            findViewById<TextView>(R.id.statusTextView).text = character.status
            findViewById<TextView>(R.id.speciesTextView).text = character.species
            findViewById<TextView>(R.id.genderTextView).text = character.gender
            findViewById<TextView>(R.id.originTextView).text = character.origin.name
            findViewById<TextView>(R.id.locationTextView).text = character.location.name
        }
    }
}
