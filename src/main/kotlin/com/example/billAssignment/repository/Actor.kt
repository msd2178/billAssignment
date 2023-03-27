package com.example.billAssignment.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository

/**
 * @author meril on 3/26/23
 */
@Table("ACTOR")
data class Actor(@Id var id: Int?, val actor: String)

interface ActorRepository : CrudRepository<Actor, String> {
    fun findByActor(actor: String): List<Actor>
}
