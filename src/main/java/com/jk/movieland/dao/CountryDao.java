package com.jk.movieland.dao;

import com.jk.movieland.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDao {
    List<Country> findByMovieId(int movieId);
}
