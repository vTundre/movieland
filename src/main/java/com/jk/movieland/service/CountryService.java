package com.jk.movieland.service;

import com.jk.movieland.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> findByMovieId(int movieId);
}
