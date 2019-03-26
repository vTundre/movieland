package com.jk.movieland.dao.cache;

import com.jk.movieland.dao.GenreDao;
import com.jk.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class GenreCache implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private GenreDao genreDao;
    private volatile List<Genre> cachedGenres;

    @Autowired
    public GenreCache(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @PostConstruct
    @Scheduled(fixedDelayString = "${cache.genreRefresh}", initialDelayString = "${cache.genreRefresh}")
    public void refreshCache() throws InterruptedException {
        log.debug("-------------CACHE REFRESH");
        cachedGenres = genreDao.findAll();
    }

    @Override
    public List<Genre> findAll() {
        return new ArrayList<>(cachedGenres);
    }
}
