package com.jk.movieland.service.impl;

import com.jk.movieland.dao.CountryDao;
import com.jk.movieland.entity.Country;
import com.jk.movieland.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> findByMovieId(int movieId) {
        return countryDao.findByMovieId(movieId);
    }
}
