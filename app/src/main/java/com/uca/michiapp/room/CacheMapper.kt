package com.uca.michiapp.room

import com.uca.michiapp.model.Cat
import com.uca.michiapp.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():

    EntityMapper<CatCacheEntity, Cat> {

    override fun mapFromEntity(entity: CatCacheEntity): Cat {
        return Cat(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: Cat): CatCacheEntity {
        return CatCacheEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }

    fun mapFromEntityList(entities: List<CatCacheEntity>): List<Cat>{
        return entities.map { mapFromEntity(it) }
    }

    }
