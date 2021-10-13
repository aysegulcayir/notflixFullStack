package com.firstAngular.notflix.repository;

import com.firstAngular.notflix.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Iterable<Movie> findAllByGenre(String genre);
    Movie findByGenre(String genre);

}
