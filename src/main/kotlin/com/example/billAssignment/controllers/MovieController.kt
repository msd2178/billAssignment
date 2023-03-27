package com.example.billAssignment.controllers

import com.example.billAssignment.model.MovieWhole
import com.example.billAssignment.repository.Movie
import com.example.billAssignment.services.ActorService
import com.example.billAssignment.services.MovieService
import org.springframework.web.bind.annotation.*

/**
 * @author meril on 3/26/23
 */
@RestController
class MovieController(val movieService: MovieService, val actorService: ActorService) {
    @GetMapping("/movies")
    fun index(): List<MovieWhole> = movieService.findMovies()

    @GetMapping("/movie/{id}")
    fun index(@PathVariable id: String): List<Movie> =
        movieService.findMovieById(id)

    @PostMapping("/movie")
    fun post(@RequestBody movieWhole: MovieWhole) {
        movieService.saveMovie(movieWhole)
    }

    @DeleteMapping("/movie/{id}")
    fun delete(@PathVariable id: Int) {
        movieService.deleteMovieById(id)
    }

    @PutMapping("/movie")
    fun put(@RequestBody movie: Movie) {
        movieService.updateMovie(movie)
    }
}
