package com.jk.movieland.service.impl;

import com.jk.movieland.dao.CountryDao;
import com.jk.movieland.dao.GenreDao;
import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.dao.ReviewDao;
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

    private MovieDao movieDao;
    private CountryDao countryDao;
    private GenreDao genreDao;
    private ReviewDao reviewDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao, CountryDao countryDao, GenreDao genreDao, ReviewDao reviewDao) {
        this.movieDao = movieDao;
        this.countryDao = countryDao;
        this.genreDao = genreDao;
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
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
        return movieDao.findByGenreId(genreId);
    }

    @Override
    public List<Movie> findByGenreId(int genreId, RequestParameters requestParameters) {
        return movieDao.findByGenreId(genreId, requestParameters);
    }

    @Override
    public Movie findById(int movieId) {
        Movie movie = movieDao.findById(movieId);
        movie.setCountries(countryDao.findByMovieId(movieId));
        movie.setGenres(genreDao.findByMovieId(movieId));
        movie.setReviews(reviewDao.findByMovieId(movieId));
        return movie;
    }
}
