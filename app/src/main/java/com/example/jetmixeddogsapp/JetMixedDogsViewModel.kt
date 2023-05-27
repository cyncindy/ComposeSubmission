package com.example.jetmixeddogsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetmixeddogsapp.data.MixedDogsRepository
import com.example.jetmixeddogsapp.model.MixedDogs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class JetMixedDogsViewModel(private val repository: MixedDogsRepository) : ViewModel() {
    private val _groupedMixedDogs = MutableStateFlow(
        repository.getMixedDogs()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedMixedDogs: StateFlow<Map<Char, List<MixedDogs>>> get() = _groupedMixedDogs

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedMixedDogs.value = repository.searchMixedDogs(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

    private val _detailDog = MutableStateFlow<MixedDogs?>(null)
    val detailDog: StateFlow<MixedDogs?> get() = _detailDog
    fun searchByID(idQuery: String){
        _detailDog.value = repository.getDogById(idQuery)
    }
}


class ViewModelFactory(private val repository: MixedDogsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JetMixedDogsViewModel::class.java)) {
            return JetMixedDogsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}