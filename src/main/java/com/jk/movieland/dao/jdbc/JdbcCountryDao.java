package com.jk.movieland.dao.jdbc;

import com.jk.movieland.dao.CountryDao;
import com.jk.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.jk.movieland.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCountryDao implements CountryDao {
    private final static String SQL_SELECT_BY_MOVIE_ID =
            "SELECT c.country_id, c.country_name FROM movie_country mc, country c " +
            "WHERE mc.country_id = c.country_id and mc.movie_id = ?";
    private final static RowMapper<Country> COUNTRY_ROW_MAPPER = new CountryRowMapper();
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCountryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findByMovieId(int movieId) {
        return jdbcTemplate.query(SQL_SELECT_BY_MOVIE_ID, COUNTRY_ROW_MAPPER, movieId);
    }
}
