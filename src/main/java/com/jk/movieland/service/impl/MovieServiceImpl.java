package com.jk.movieland.service.impl;

import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${random.movies.count}")
    private int randomMoviesCount;

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = movieDao.findAll();
        return movies;
    }

    @Override
    public List<Movie> findRandom() {
        return movieDao.findRandom(randomMoviesCount);
    }

    @Override
    public List<Movie> findByGenreId(int genreId) {
        List<Movie> movies = movieDao.findByGenreId(genreId);
        return movies;
    }
}
