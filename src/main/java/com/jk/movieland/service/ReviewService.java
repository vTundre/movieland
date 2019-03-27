package com.jk.movieland.service;

import com.jk.movieland.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByMovieId(int movieId);
}
