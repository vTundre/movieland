package com.jk.movieland.service.impl;

import com.jk.movieland.dao.ReviewDao;
import com.jk.movieland.entity.Review;
import com.jk.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewDao reviewDao;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> findByMovieId(int movieId) {
        return reviewDao.findByMovieId(movieId);
    }
}
