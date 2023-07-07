package com.example.harrypotter.ui.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotter.R
import com.example.harrypotter.databinding.ItemCharacterBinding
import com.example.harrypotter.data.model.CharacterModel

class CharacterAdapter(val characters: List<CharacterModel>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {


        val binding = ItemCharacterBinding.bind(view)
        fun updateUI(character: CharacterModel) {
            binding.apply {
                tvName.text = character.name

                Glide.with(view)
                    .load(character.image)
                    .placeholder(R.drawable.placeholder_image)

                    .into(ivCharacter)

                cvCharacter.setOnClickListener {
                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_navigation_home_to_navigation_character_detail,
                        bundleOf(
                            "id_character" to character.id
                        )
                    )

                }
            }
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)

        )
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        characters[position]?.let { holder.updateUI(it) }

    }


}