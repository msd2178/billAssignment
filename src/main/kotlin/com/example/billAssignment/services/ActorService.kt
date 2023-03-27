package com.example.billAssignment.services

import com.example.billAssignment.repository.Actor
import com.example.billAssignment.repository.ActorRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author meril on 3/26/23
 */
@Service
class ActorService(val db: ActorRepository) {
    fun findActors(): List<Actor> = db.findAll().toList()

    fun findActorById(id: Int): List<Actor> = db.findById(id.toString()).toList()

    fun findActorByName(actor: String): List<Actor> = db.findByActor(actor).toList()

    fun saveActor(actor: Actor) {
        db.save(actor)
    }

    fun updateActor(actor: Actor) {
        if (!db.findById(actor.id.toString()).isEmpty) {
            db.save(actor);
        }
    }

    fun deleteActorById(id: Int) {
        if (!db.findById(id.toString()).isEmpty) {
            db.delete(db.findById(id.toString()).get());
        }
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
