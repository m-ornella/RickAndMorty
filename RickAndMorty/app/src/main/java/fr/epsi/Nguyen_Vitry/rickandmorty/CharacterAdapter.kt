package fr.epsi.Nguyen_Vitry.rickandmorty

import fr.epsi.Nguyen_Vitry.rickandmorty.model.Character
import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import coil.load
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.os.Parcelable


class CharactersAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount() = characters.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val characterImageView: ImageView = itemView.findViewById(R.id.characterImageView)
        init {
            itemView.setOnClickListener {
                val character = characters[adapterPosition]
                val intent = Intent(itemView.context, CharacterDetailsActivity::class.java)
                intent.putExtra("character", character as Parcelable)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(character: Character) {
            nameTextView.text = character.name
            characterImageView.load(character.image)
        }
    }
}
