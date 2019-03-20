package com.jk.movieland.controller;

import com.jk.movieland.entity.Genre;
import com.jk.movieland.service.GenreService;
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
public class GenreControllerTest {
    private MockMvc mockMvc;
    private GenreService genreService = mock(GenreService.class);
    private List<Genre> genres;

    @Before
    public void setUp() {
        GenreController genreController = new GenreController(genreService);
        mockMvc = standaloneSetup(genreController).build();

        Genre first = new Genre();
        first.setId(1);
        first.setName("Ужасы");

        Genre second = new Genre();
        second.setId(2);
        second.setName("Фантастика");
        genres = Arrays.asList(first, second);
    }

    @Test
    public void testGetAllGenres() throws Exception {
        String uri = "/genre";
        when(genreService.findAll()).thenReturn(genres);
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Ужасы")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Фантастика")));
    }
}

