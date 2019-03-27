package com.jk.movieland.dao.jdbc;

import com.jk.movieland.dao.GenreDao;
import com.jk.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.jk.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private final static String SQL_SELECT_ALL_GENRES = "SELECT genre_id, genre_name FROM genre";
    private final static String SQL_SELECT_BY_MOVIE_ID = "SELECT g.genre_id, g.genre_name " +
            "FROM genre g, movie_genre mg " +
            "WHERE g.genre_id = mg.genre_id AND mg.movie_id = ?";
    private final static RowMapper<Genre> GENRE_ROW_MAPPER = new GenreRowMapper();
    private final Logger log = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> findAll() {
        log.debug("Start query to get all genres from DB");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = jdbcTemplate.query(SQL_SELECT_ALL_GENRES, GENRE_ROW_MAPPER);
        log.debug("Finish query to get all genres from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return genres;
    }

    @Override
    public List<Genre> findByMovieId(int movieId) {
        return jdbcTemplate.query(SQL_SELECT_BY_MOVIE_ID, GENRE_ROW_MAPPER, movieId);
    }
}
