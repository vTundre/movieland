package com.jk.movieland.controller;

import com.jk.movieland.entity.Movie;
import com.jk.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class MovieControllerTest {
    private MockMvc mockMvc;
    private MovieService movieService = mock(MovieService.class);
    private List<Movie> movies;

    @Before
    public void setUp() {
        MovieController movieController = new MovieController(movieService);
        mockMvc = standaloneSetup(movieController).build();

        Movie first = new Movie();
        first.setId(1);
        first.setNameRussian("Сияние");
        first.setNameNative("Shining");
        first.setYearOfRelease("1990");
        first.setRating(3.2);
        first.setPrice(120233.333);

        Movie second = new Movie();
        second.setId(2);
        second.setNameRussian("Два");
        second.setNameNative("Second");
        second.setYearOfRelease("2222");
        second.setRating(1.0);
        second.setPrice(1.0);
        movies = Arrays.asList(first, second);
    }

    @Test
    public void testGetAllMovies() throws Exception {
        String uri = "/movie";
        when(movieService.findAll()).thenReturn(movies);
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nameRussian", is("Сияние")))
                .andExpect(jsonPath("$[0].nameNative", is("Shining")))
                .andExpect(jsonPath("$[0].yearOfRelease", is("1990")))
                .andExpect(jsonPath("$[0].rating", is(3.2)))
                .andExpect(jsonPath("$[0].price", is(120233.333)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nameRussian", is("Два")))
                .andExpect(jsonPath("$[1].nameNative", is("Second")))
                .andExpect(jsonPath("$[1].yearOfRelease", is("2222")))
                .andExpect(jsonPath("$[1].rating", is(1.0)))
                .andExpect(jsonPath("$[1].price", is(1.0)));
    }
}
