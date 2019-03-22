package com.jk.movieland.service;


import com.jk.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    List<Movie> findRandom();

    List<Movie> findByGenreId(int GenreId);
}