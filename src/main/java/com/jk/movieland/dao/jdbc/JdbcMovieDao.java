package com.jk.movieland.dao.jdbc;

import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.jk.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private final static String SQL_SELECT_ALL_MOVIES = "SELECT movie_id, movie_name_russian, movie_name_native, movie_year_of_release, movie_rating, movie_price FROM movie";

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final RowMapper<Movie> movieRowMapper = new MovieRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> findAll() {
        log.debug("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(SQL_SELECT_ALL_MOVIES, movieRowMapper);
        log.debug("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

}
