package com.example.billAssignment.model

import com.example.billAssignment.repository.Actor
import org.jetbrains.annotations.NotNull

/**
 * @author meril on 3/26/23
 */
class MovieWhole {
    var id: Int? = null
    var title: String = ""
    var releasedate: String = ""
    @field:NotNull
    var actors: List<Actor> = listOf<Actor>()
}