package com.uca.michiapp.room

import com.uca.michiapp.model.Breed
import com.uca.michiapp.retrofit.BreedNetworkEntity
import com.uca.michiapp.utils.EntityMapper
import javax.inject.Inject

class BreedCacheMapper
@Inject
constructor():
        EntityMapper<BreedCacheEntity, Breed>{

        override fun mapFromEntity(entity: BreedCacheEntity): Breed {
                return Breed(
                        id = entity.id,
                        name = entity.name,
                        origin = entity.origin,
                        description = entity.description,
                        lifeSpan = entity.life_span,
                        wikipediaURL = entity.wikipedia_url,
                        image = entity.image,
                        weight = entity.weight,
                        temperament = entity.temperament
                )
        }

        override fun mapToEntity(domainModel: Breed): BreedCacheEntity {
                return BreedCacheEntity(
                        id = domainModel.id,
                        name = domainModel.name,
                        origin = domainModel.origin,
                        description = domainModel.description,
                        life_span = domainModel.lifeSpan,
                        wikipedia_url = domainModel.wikipediaURL,
                        image = domainModel.image,
                        weight = domainModel.weight,
                        temperament = domainModel.temperament
                )
        }

        fun mapFromEntityListBreed(entities: List<BreedCacheEntity>): List<Breed>{
                return entities.map { mapFromEntity(it) }
        }

        }