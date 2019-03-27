package com.jk.movieland.dao.jdbc.mapper;

import com.jk.movieland.entity.Review;
import com.jk.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setNickname(resultSet.getString("name"));

        Review review = new Review();
        review.setId(resultSet.getInt("review_id"));
        review.setText(resultSet.getString("review_text"));
        review.setUser(user);
        return review;
    }
}
