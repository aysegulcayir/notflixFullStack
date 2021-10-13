package com.firstAngular.notflix.service;

import com.firstAngular.notflix.model.Movie;
import com.firstAngular.notflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Iterable<Movie> getAll(){

        return this.movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie){
        Optional<Movie> tempMovie = this.movieRepository.findById(movie.getId());
        tempMovie.get().setLink(movie.getLink());
        return tempMovie.get();
    }

    public void deleteMovie(long id){

        Optional<Movie> movie = this.movieRepository.findById(id);
        this.movieRepository.delete(movie.get());
    }

    public Iterable<Movie> findAllMoviesByGenre(String genre) {
        return this.movieRepository.findAllByGenre(genre);
    }


    public Movie findMovieByGenre(String genre) {
        return this.movieRepository.findByGenre(genre);

    }


}
