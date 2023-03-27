package com.example.billAssignment.services


import com.example.billAssignment.repository.MovieActor
import com.example.billAssignment.repository.MovieActorRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author meril on 3/26/23
 */
@Service
class MovieActorService(val db: MovieActorRepository) {
    fun findMovieActors(): List<MovieActor> = db.findAll().toList()

    fun findMovieActorById(id: String): List<MovieActor> = db.findById(id).toList()

    fun save(movieActor: MovieActor) {
        db.save(movieActor)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
