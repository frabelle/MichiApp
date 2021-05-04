package com.uca.michiapp.utils

import com.uca.michiapp.model.Breed
import com.uca.michiapp.model.Cat
import java.lang.Exception

sealed class DataState {
    object Idle: DataState()
    data class Success(val cats: List<Cat>): DataState()
    data class SuccessBreed(val breed: List<Breed>): DataState()
    data class Error(val exception: Exception): DataState()
    object Loading: DataState()
}