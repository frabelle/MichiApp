package com.uca.michiapp.retrofit

import com.uca.michiapp.model.Cat
import com.uca.michiapp.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<CatNetworkEntity, Cat> {
    override fun mapFromEntity(entity: CatNetworkEntity): Cat{
        return Cat(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: Cat): CatNetworkEntity {
        return CatNetworkEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }

    fun mapFromEntityList(entities: List<CatNetworkEntity>): List<Cat>{
        return entities.map { mapFromEntity(it) }
    }
}