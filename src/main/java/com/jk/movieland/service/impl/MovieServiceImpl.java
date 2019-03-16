package com.jk.movieland.service.impl;

import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = movieDao.findAll();
        return movies;
    }
}
