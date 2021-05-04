package com.uca.michiapp.model

typealias Breeds = ArrayList<Breed>

data class Breed (
    val id: String,
    val name: String,
    val origin: String,
    val description: String,
    val lifeSpan: String,
    val wikipediaURL: String,
    val image: Image,
    val weight: Weight
)