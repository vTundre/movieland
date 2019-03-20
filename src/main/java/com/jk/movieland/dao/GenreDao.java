package com.jk.movieland.dao;

import com.jk.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> findAll();
}
