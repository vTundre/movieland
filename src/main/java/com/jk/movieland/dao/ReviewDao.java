package com.jk.movieland.dao;

import com.jk.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> findByMovieId(int movieId);
}
