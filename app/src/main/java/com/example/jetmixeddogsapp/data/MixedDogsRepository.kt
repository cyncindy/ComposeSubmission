package com.example.jetmixeddogsapp.data

import com.example.jetmixeddogsapp.model.MixedDogs
import com.example.jetmixeddogsapp.model.MixedDogsData

class MixedDogsRepository {
    fun getMixedDogs(): List<MixedDogs> {
        return MixedDogsData.mixedDogs
    }

    fun searchMixedDogs(query: String): List<MixedDogs> {
        return MixedDogsData.mixedDogs.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getDogById(query: String): MixedDogs?{
        return MixedDogsData.mixedDogs.firstOrNull{
            it.id == query
        }
    }
}