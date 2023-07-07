package com.example.harrypotter.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.harrypotter.R
import com.example.harrypotter.databinding.FragmentDetailCharacterBinding
import com.example.harrypotter.data.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {
    @Inject
    lateinit var repository: Repository
    lateinit var binding: FragmentDetailCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailCharacterBinding.inflate(inflater, container, false)
        val currentId = arguments?.getString("id_character") ?: ""
        getCharacterById(currentId)


        return binding.root
    }

    private fun getCharacterById(currentId: String) {
        CoroutineScope(Dispatchers.Main).launch {
            binding.idProgressBar.visibility = View.VISIBLE

            try {
                val character = repository.getCharacterById(currentId)
                binding.apply {
                    tvName.setText(getString(R.string.character_name, character.name))
                    tvAlternateNames.setText(
                        getString(
                            R.string.character_alternate_names,
                            character.alternateNames?.joinToString(separator = ", ")
                        )
                    )
                    tvActor.setText(getString(R.string.actor, character.actor))
                    tvGender.setText(getString(R.string.character_gender, character.gender))
                    tvEyeColor.setText(
                        getString(
                            R.string.character_eye_colour,
                            character.eyeColour
                        )
                    )
                    tvHairColor.setText(
                        getString(
                            R.string.character_hair_colour,
                            character.hairColour
                        )
                    )
                    tvDateOfBirth.setText(
                        getString(
                            R.string.character_date_of_birth,
                            character.dateOfBirth.toString()
                        )
                    )

                }
                Glide.with(requireContext())
                    .load(character.image)
                    .placeholder(R.drawable.placeholder_image)
                    .into(binding.ivCharacter)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                binding.idProgressBar.visibility = View.GONE
            }

        }
    }
}