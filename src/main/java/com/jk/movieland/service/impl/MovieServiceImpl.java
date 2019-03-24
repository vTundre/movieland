package com.jk.movieland.service.impl;

import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.MovieService;
import com.jk.movieland.utils.RequestParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${movie.randomCount}")
    private int randomMoviesCount;

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> findAll() {
        return findAll(null);
    }

    @Override
    public List<Movie> findAll(RequestParameters requestParameters) {
        return movieDao.findAll(requestParameters);
    }

    @Override
    public List<Movie> findRandom() {
        return movieDao.findRandom(randomMoviesCount);
    }

    @Override
    public List<Movie> findByGenreId(int genreId) {
        return findByGenreId(genreId, null);
    }

    @Override
    public List<Movie> findByGenreId(int genreId, RequestParameters requestParameters) {
        return movieDao.findByGenreId(genreId, requestParameters);
    }

    @Override
    public Movie findById(int movieId) {
        return movieDao.findById(movieId);
    }
}
