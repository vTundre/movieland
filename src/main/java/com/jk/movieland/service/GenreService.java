package com.jk.movieland.service;

import com.jk.movieland.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();

    List<Genre> findByMovieId(int movieId);
}
