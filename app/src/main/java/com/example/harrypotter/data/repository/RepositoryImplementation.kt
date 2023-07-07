package com.example.harrypotter.data.repository

import com.example.harrypotter.data.model.CharacterModel
import com.example.harrypotter.data.remote.harryPotterCall
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    val harryPotterCall: harryPotterCall
) : Repository {
    override suspend fun getAllCharcters(): List<CharacterModel> {
        return harryPotterCall.getAllCharcters()

    }

    override suspend fun getCharacterById(id: String): CharacterModel {
        return harryPotterCall.getCharacterById(id)
    }
}