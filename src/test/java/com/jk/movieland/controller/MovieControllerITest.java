package com.jk.movieland.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:movieland-servlet.xml", "classpath:test-context.xml"})
@WebAppConfiguration
public class MovieControllerITest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllMoviesSortByRatingDesc() throws Exception {
        String uri = "/movie?rating=desc";
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("$[0].nameNative", is("The Green Mile")))
                .andExpect(jsonPath("$[0].yearOfRelease", is("1999")))
                .andExpect(jsonPath("$[0].rating", is(9.0)))
                .andExpect(jsonPath("$[0].price", is(134.67)));
    }

    @Test
    public void testGetAllMoviesSortByPriceAsc() throws Exception {
        String uri = "/movie?price=asc";
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nameRussian", is("Побег из Шоушенка")))
                .andExpect(jsonPath("$[0].nameNative", is("The Shawshank Redemption")))
                .andExpect(jsonPath("$[0].yearOfRelease", is("1994")))
                .andExpect(jsonPath("$[0].rating", is(8.9)))
                .andExpect(jsonPath("$[0].price", is(123.45)));
    }

    @Test
    public void testGetByGenreIdSortByRatingDesc() throws Exception {
        String uri = "/movie/genre/1?rating=desc";
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("$[0].nameNative", is("The Green Mile")))
                .andExpect(jsonPath("$[0].yearOfRelease", is("1999")))
                .andExpect(jsonPath("$[0].rating", is(9.0)))
                .andExpect(jsonPath("$[0].price", is(134.67)));
    }

    @Test
    public void testGetByGenreIdSortByPriceDesc() throws Exception {
        String uri = "/movie/genre/1?price=desc";
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(3)))
                .andExpect(jsonPath("$[0].nameRussian", is("Форрест Гамп")))
                .andExpect(jsonPath("$[0].nameNative", is("Forrest Gump")))
                .andExpect(jsonPath("$[0].yearOfRelease", is("1994")))
                .andExpect(jsonPath("$[0].rating", is(8.6)))
                .andExpect(jsonPath("$[0].price", is(200.60)));
    }

    @Test
    public void testGetMovieById() throws Exception {
        String uri = "/movie/2";
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(2)))
                .andExpect(jsonPath("nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("nameNative", is("The Green Mile")))
                .andExpect(jsonPath("yearOfRelease", is("1999")))
                .andExpect(jsonPath("description", is("Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.")))
                .andExpect(jsonPath("rating", is(9.0)))
                .andExpect(jsonPath("price", is(134.67)));
    }
}
