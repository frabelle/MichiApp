package com.uca.michiapp.retrofit

import com.uca.michiapp.model.Breed
import com.uca.michiapp.model.Cat
import com.uca.michiapp.utils.EntityMapper
import javax.inject.Inject

class BreedNetworkMapper
@Inject
constructor(): EntityMapper<BreedNetworkEntity, Breed>{
    override fun mapFromEntity(entity: BreedNetworkEntity): Breed {
        return Breed(
                id = entity.id,
                name = entity.name,
                origin = entity.origin,
                description = entity.description,
                lifeSpan = entity.life_span,
                wikipediaURL = entity.wikipedia_url,
                image = entity.image,
                weight = entity.weight
        )
    }

    override fun mapToEntity(domainModel: Breed): BreedNetworkEntity {
        return BreedNetworkEntity(
                id = domainModel.id,
                name = domainModel.name,
                origin = domainModel.origin,
                description = domainModel.description,
                life_span = domainModel.lifeSpan,
                wikipedia_url = domainModel.wikipediaURL,
                image = domainModel.image,
                weight = domainModel.weight
        )
    }

    fun mapfromEntityListBreed(entities: List<BreedNetworkEntity>): List<Breed>{
        return entities.map { mapFromEntity(it) }
    }
}