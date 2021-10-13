package com.firstAngular.notflix.controller;

import com.firstAngular.notflix.model.Movie;
import com.firstAngular.notflix.repository.MovieRepository;
import com.firstAngular.notflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin("**")
@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies")
    public Iterable<Movie> getMovies() {
        return this.movieService.getAll();
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {

        Optional<Movie> movie = this.movieRepository.findById(id);
        return new ResponseEntity<>(movie.get(), HttpStatus.OK);

    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<Movie> getMovieByGenre(@PathVariable String genre) {

        Movie movie = this.movieService.findMovieByGenre(genre);
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }

    @PostMapping("/movie")
    public Movie saveMovie(@RequestBody Movie movie) {
        this.movieService.addMovie(movie);
        return movie;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(this.movieService.updateMovie(movie),HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable long id){
        this.movieRepository.deleteById(id);
    }
}
