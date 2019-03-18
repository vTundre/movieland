package com.jk.movieland.dao;

import com.jk.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();

    List<Movie> findRandom(int count);
}
