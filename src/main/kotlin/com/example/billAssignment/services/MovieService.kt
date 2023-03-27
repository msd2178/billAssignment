package com.example.billAssignment.services

import com.example.billAssignment.*
import com.example.billAssignment.model.MovieWhole
import com.example.billAssignment.repository.*
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author meril on 3/26/23
 */
@Service
class MovieService(val movieDb: MovieRepository, val actorDb: ActorRepository, val movieActorDb: MovieActorRepository) {
    fun findMovies(): List<MovieWhole> {
        var movies : List<Movie> = movieDb.findAll().toList()

        var moviesWhole = ArrayList<MovieWhole>()

        for (movie in movies) {
            val movieWhole = MovieWhole()
            movieWhole.id = movie.id
            movieWhole.title = movie.title
            movieWhole.releasedate = movie.releasedate

            var actors = ArrayList<Actor>()

            var movieActorList : List<MovieActor>? = movie.id?.let { movieActorDb.findActorsByIdMovie(it) }

            if (movieActorList != null) {
                for (movieActor in movieActorList) {
                    actors.add(actorDb.findById(movieActor.idActor.toString()).get())
                }
            }

            movieWhole.actors = actors

            moviesWhole.add(movieWhole)
        }

        return moviesWhole
    }

    fun findMovieById(id: String): List<Movie> = movieDb.findById(id).toList()

    fun saveMovie(movieWhole: MovieWhole) {

        if (movieWhole.actors.isEmpty() || movieWhole.title.isEmpty() || movieWhole.releasedate.isEmpty()) {
            throw IllegalArgumentException("missing data")
        }

        val movie = Movie(null, movieWhole.title, movieWhole.releasedate)
        movieDb.save(movie)

        var movieFetched : List<Movie> = movieDb.findByTitleAndReleasedate(movie.title, movie.releasedate)

        var actors: List<Actor> = movieWhole.actors.toSet().toList();
        for (actor in actors) {
            var existingActor: List<Actor> = actorDb.findByActor(actor.actor)
            if (existingActor.isEmpty()) {
                actorDb.save(actor)
            } else {
                println("already exists! - " + actor.actor)
            }
            var actorFetched: List<Actor> = actorDb.findByActor(actor.actor)

            var movieId: Int? = movieFetched.get(0).id
            var actorId : Int? = actorFetched.get(0).id

            val movieActor = MovieActor(null, movieId, actorId)
            movieActorDb.save(movieActor)

        }
    }

    fun updateMovie(movie: Movie) {
        if (!movieDb.findById(movie.id.toString()).isEmpty) {
            movieDb.save(movie);
        }
    }

    fun deleteMovieById(id: Int) {
        if (!movieDb.findById(id.toString()).isEmpty) {
            var movieActorList : List<MovieActor> = movieActorDb.findActorsByIdMovie(id)

                for (movieActor in movieActorList) {
                    movieActorDb.delete(movieActor)
                }

            movieDb.delete(movieDb.findById(id.toString()).get());
        }
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}