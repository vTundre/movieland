package com.jk.movieland.service.impl;

import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.CountryService;
import com.jk.movieland.service.GenreService;
import com.jk.movieland.service.MovieService;
import com.jk.movieland.service.ReviewService;
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
    private CountryService countryService;
    private GenreService genreService;
    private ReviewService reviewService;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao, CountryService countryService, GenreService genreService, ReviewService reviewService) {
        this.movieDao = movieDao;
        this.countryService = countryService;
        this.genreService = genreService;
        this.reviewService = reviewService;
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
        movie.setCountries(countryService.findByMovieId(movieId));
        movie.setGenres(genreService.findByMovieId(movieId));
        movie.setReviews(reviewService.findByMovieId(movieId));
        return movie;
    }
}
