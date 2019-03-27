package com.jk.movieland.dao.jdbc.mapper;

import com.jk.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapperFull implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieRowMapper movieRowMapper = new MovieRowMapper();
        Movie movie = movieRowMapper.mapRow(resultSet, i);
        movie.setDescription(resultSet.getString("movie_description"));
        return movie;
    }
}
