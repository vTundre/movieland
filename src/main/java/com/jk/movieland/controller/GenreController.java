package com.jk.movieland.controller;

import com.jk.movieland.entity.Genre;
import com.jk.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GenreController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        log.debug("Sending request to get all genres");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = genreService.findAll();
        log.debug("Genres are received. It took {} ms", System.currentTimeMillis() - startTime);
        return genres;
    }
}