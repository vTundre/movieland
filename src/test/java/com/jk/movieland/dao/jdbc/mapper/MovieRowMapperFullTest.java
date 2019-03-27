package com.jk.movieland.dao.jdbc.mapper;

import com.jk.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperFullTest {
    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("movie_id")).thenReturn(1);
        when(resultSet.getString("movie_name_russian")).thenReturn("Сияние");
        when(resultSet.getString("movie_name_native")).thenReturn("Shining");
        when(resultSet.getString("movie_year_of_release")).thenReturn("1990");
        when(resultSet.getString("movie_description")).thenReturn("описание");
        when(resultSet.getDouble("movie_rating")).thenReturn(3.2);
        when(resultSet.getDouble("movie_price")).thenReturn(120233.333);

        MovieRowMapperFull movieRowMapperFull = new MovieRowMapperFull();
        Movie actualMovie = movieRowMapperFull.mapRow(resultSet, 0);
        assertEquals(1, actualMovie.getId());
        assertEquals("Сияние", actualMovie.getNameRussian());
        assertEquals("Shining", actualMovie.getNameNative());
        assertEquals("1990", actualMovie.getYearOfRelease());
        assertEquals("описание", actualMovie.getDescription());
        assertEquals(3.2, actualMovie.getRating(), 0);
        assertEquals(120233.333, actualMovie.getPrice(), 0);
    }
}
