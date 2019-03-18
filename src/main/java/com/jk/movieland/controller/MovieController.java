package com.jk.movieland.controller;

import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        log.debug("Sending request to get all movies");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = movieService.findAll();
        log.debug("Movies are received. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @GetMapping(path = "random")
    public List<Movie> getRandomMovies() {
        log.debug("Sending request to get random movies");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = movieService.findRandom();
        log.debug("Movies are received. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }
}
