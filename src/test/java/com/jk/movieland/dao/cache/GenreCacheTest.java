package com.jk.movieland.dao.cache;

import com.jk.movieland.dao.GenreDao;
import com.jk.movieland.dao.cache.GenreCache;
import com.jk.movieland.entity.Genre;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class GenreCacheTest {
    @Test
    public void testFindAll() {
        GenreDao genreDao = mock(GenreDao.class);
        GenreCache genreCache = new GenreCache(genreDao);

        Genre first = new Genre();
        first.setId(1);
        first.setName("Ужасы");

        Genre second = new Genre();
        second.setId(2);
        second.setName("Фантастика");

        when(genreDao.findAll()).thenReturn(Arrays.asList(first, second));

        genreCache.refreshCache();
        genreCache.findAll();
        genreCache.findAll();

        verify(genreDao, times(1)).findAll();
        verifyNoMoreInteractions(genreDao);
    }
}
