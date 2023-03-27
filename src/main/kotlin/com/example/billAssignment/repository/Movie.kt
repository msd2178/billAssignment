package com.example.billAssignment.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository

/**
 * @author meril on 3/26/23
 */
@Table("MOVIE")
data class Movie(@Id var id: Int?, val title: String, val releasedate: String)

interface MovieRepository : CrudRepository<Movie, String> {
    fun findByTitleAndReleasedate(title: String, releasedate: String): List<Movie>
}