package com.jk.movieland.dao.jdbc.mapper;

import com.jk.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("movie_id"));
        movie.setNameRussian(resultSet.getString("movie_name_russian"));
        movie.setNameNative(resultSet.getString("movie_name_native"));
        movie.setYearOfRelease(resultSet.getString("movie_year_of_release"));
        movie.setRating(resultSet.getDouble("movie_rating"));
        movie.setPrice(resultSet.getDouble("movie_price"));
        return movie;
    }
}
