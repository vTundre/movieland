package com.jk.movieland.dao.jdbc.mapper;

import com.jk.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapperFull implements RowMapper<Movie> {
    private static final RowMapper<Movie> MOVIE_ROW_MAPPER = new MovieRowMapper();

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = MOVIE_ROW_MAPPER.mapRow(resultSet, i);
        movie.setDescription(resultSet.getString("movie_description"));
        return movie;
    }
}
