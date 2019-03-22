package com.jk.movieland.service.impl;

import com.jk.movieland.dao.GenreDao;
import com.jk.movieland.entity.Genre;
import com.jk.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDao genreDao;

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }
}
