package com.jk.movieland.controller;

import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.MovieService;
import com.jk.movieland.utils.RequestParameters;
import com.jk.movieland.utils.SortDirection;
import com.jk.movieland.utils.SortDirectionConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    public List<Movie> getAllMovies(@RequestParam(name = "rating", required = false) SortDirection ratingOrder,
                                    @RequestParam(name = "price", required = false) SortDirection priceOrder) {
        log.debug("Sending request to get all movies. Order by {}, {}", ratingOrder, priceOrder);
        if (ratingOrder == null && priceOrder == null) {
            return movieService.findAll();
        }
        RequestParameters requestParameters = new RequestParameters(ratingOrder, priceOrder);
        return movieService.findAll(requestParameters);
    }

    @GetMapping(path = "random")
    public List<Movie> getRandomMovies() {
        log.debug("Sending request to get random movies");
        return movieService.findRandom();
    }

    @GetMapping(path = "genre/{genreId}")
    public List<Movie> getMoviesByGenre(@PathVariable int genreId,
                                        @RequestParam(name = "rating", required = false) SortDirection ratingOrder,
                                        @RequestParam(name = "price", required = false) SortDirection priceOrder) {
        log.debug("Sending request to get movies by genre. Order by {}, {}", ratingOrder, priceOrder);
        if (ratingOrder == null && priceOrder == null) {
            return movieService.findByGenreId(genreId);
        }
        RequestParameters requestParameters = new RequestParameters(ratingOrder, priceOrder);
        return movieService.findByGenreId(genreId, requestParameters);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(SortDirection.class, new SortDirectionConverter());
    }
}
