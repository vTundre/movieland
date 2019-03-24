package com.jk.movieland.service;


import com.jk.movieland.entity.Movie;
import com.jk.movieland.utils.RequestParameters;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    List<Movie> findAll(RequestParameters requestParameters);

    List<Movie> findRandom();

    List<Movie> findByGenreId(int GenreId);

    List<Movie> findByGenreId(int GenreId, RequestParameters requestParameters);

    Movie findById(int movieId);
}