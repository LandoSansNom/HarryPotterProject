package com.example.harrypotter.data.repository

import com.example.harrypotter.data.model.CharacterModel
import retrofit2.http.Path

interface Repository {
    suspend fun getAllCharcters(): List<CharacterModel>
    suspend fun getCharacterById(@Path("id") id: String): List<CharacterModel>


}