package com.jk.movieland.dao.jdbc;

import com.jk.movieland.dao.MovieDao;
import com.jk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.jk.movieland.dao.jdbc.mapper.MovieRowMapperFull;
import com.jk.movieland.dao.jdbc.utils.QueryBuilder;
import com.jk.movieland.entity.Movie;
import com.jk.movieland.utils.RequestParameters;
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
    private final static String SQL_SELECT_RANDOM = "SELECT movie_id, movie_name_russian, movie_name_native, movie_year_of_release, movie_rating, movie_price FROM movie ORDER BY random() LIMIT ?";
    private final static String SQL_SELECT_MOVIES_BY_GENRE_ID =
            "SELECT m.movie_id, m.movie_name_russian, m.movie_name_native, m.movie_year_of_release, m.movie_rating, m.movie_price " +
                    "FROM movie m, movie_genre mg where m.movie_id = mg.movie_id and mg.genre_id = ?";
    private final static String SQL_SELECT_MOVIE_BY_ID =
            "SELECT m.movie_id, m.movie_name_russian, m.movie_name_native, m.movie_year_of_release, m.movie_description, m.movie_rating, m.movie_price " +
                    "FROM movie m where m.movie_id = ?";

    private final static RowMapper<Movie> MOVIE_ROW_MAPPER = new MovieRowMapper();
    private final static RowMapper<Movie> MOVIE_ROW_MAPPER_FULL = new MovieRowMapperFull();
    private final Logger log = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAll(RequestParameters requestParameters) {
        log.debug("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        String sql = QueryBuilder.prepareSql(SQL_SELECT_ALL_MOVIES, requestParameters);
        List<Movie> movies = jdbcTemplate.query(sql, MOVIE_ROW_MAPPER);
        log.debug("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> findRandom(int count) {
        log.debug("Start query to get {} random movies from DB", count);
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(SQL_SELECT_RANDOM, MOVIE_ROW_MAPPER, count);
        log.debug("Finish query to get {} random movies from DB. It took {} ms", count, System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> findByGenreId(int genreId, RequestParameters requestParameters) {
        log.debug("Start query to get movies by genreId {} from DB", genreId);
        long startTime = System.currentTimeMillis();
        String sql = QueryBuilder.prepareSql(SQL_SELECT_MOVIES_BY_GENRE_ID, requestParameters);
        List<Movie> movies = jdbcTemplate.query(sql, MOVIE_ROW_MAPPER, genreId);
        log.debug("Finish query to get movies by genreId {} from DB. It took {} ms", genreId, System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public Movie findById(int movieId) {
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(SQL_SELECT_MOVIE_BY_ID, MOVIE_ROW_MAPPER_FULL, movieId);
        log.debug("Finish query to get movie by Id {} from DB. It took {} ms", movieId, System.currentTimeMillis() - startTime);
        return movie;
    }


}
