package com.example.billAssignment.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository

/**
 * @author meril on 3/26/23
 */
@Table("MOVIE_ACTOR")
data class MovieActor(@Id var id: Int?, var idMovie: Int?, var idActor: Int?)

interface MovieActorRepository : CrudRepository<MovieActor, String> {
    fun findActorsByIdMovie(movieId: Int): List<MovieActor>
}