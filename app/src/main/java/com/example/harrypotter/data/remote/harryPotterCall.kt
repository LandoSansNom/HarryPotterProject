package com.example.harrypotter.data.remote

import com.example.harrypotter.data.model.CharacterModel
import retrofit2.http.GET
import retrofit2.http.Path

interface harryPotterCall {

    @GET(ApiDetails.End_Point_All_Characters)
    suspend fun getAllCharcters(): List<CharacterModel>

    @GET(ApiDetails.End_Point_Character_By_Id)
    suspend fun getCharacterById(@Path("id") id: String): CharacterModel
}