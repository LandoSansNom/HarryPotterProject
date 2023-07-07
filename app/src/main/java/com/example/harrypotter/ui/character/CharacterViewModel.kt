package com.example.harrypotter.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harrypotter.data.model.CharacterModel
import com.example.harrypotter.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val models: MutableLiveData<List<CharacterModel>> by lazy {
        MutableLiveData<List<CharacterModel>>()
    }

    var isLoaded = false
    fun getAllCharacter(){
        CoroutineScope(Dispatchers.Main).launch {
            var result = repository.getAllCharcters()
            models.postValue(result)
            isLoaded = true
        }
    }

}