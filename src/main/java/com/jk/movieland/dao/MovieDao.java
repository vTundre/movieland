package com.jk.movieland.dao;

import com.jk.movieland.entity.Movie;
import com.jk.movieland.utils.RequestParameters;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll(RequestParameters requestParameter);

    List<Movie> findRandom(int count);

    List<Movie> findByGenreId(int genreId, RequestParameters requestParameters);

    Movie findById(int movieId);
}
