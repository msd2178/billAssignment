package com.example.billAssignment.controllers

import com.example.billAssignment.repository.Actor
import com.example.billAssignment.services.ActorService
import org.springframework.web.bind.annotation.*

/**
 * @author meril on 3/26/23
 */
@RestController
class ActorController(val service: ActorService) {
    @GetMapping("/actors")
    fun index(): List<Actor> = service.findActors()

    @GetMapping("/actor/{id}")
    fun index(@PathVariable id: Int): List<Actor> =
        service.findActorById(id)

    @GetMapping("/actor/name/{name}")
    fun index(@PathVariable name: String): List<Actor> =
        service.findActorByName(name)

    @PostMapping("/actor")
    fun post(@RequestBody actor: Actor) {
        service.saveActor(actor)
    }

    @DeleteMapping("/actor/{id}")
    fun delete(@PathVariable id: Int) {
        service.deleteActorById(id)
    }

    @PutMapping("/actor")
    fun put(@RequestBody actor: Actor) {
        service.updateActor(actor)
    }
}