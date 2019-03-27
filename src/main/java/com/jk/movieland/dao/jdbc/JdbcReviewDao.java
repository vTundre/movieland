package com.jk.movieland.dao.jdbc;

import com.jk.movieland.dao.ReviewDao;
import com.jk.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.jk.movieland.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao {
    private final static String SQL_SELECT_BY_MOVIE_ID =
            "SELECT r.review_id, r.review_text, u.user_id, u.user_first_name || ' ' ||  u.user_last_name as name " +
                    "FROM review r, app_user u " +
                    "WHERE r.user_id = u.user_id and r.movie_id = ?";

    private final static RowMapper<Review> REVIEW_ROW_MAPPER = new ReviewRowMapper();

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> findByMovieId(int movieId) {
        return jdbcTemplate.query(SQL_SELECT_BY_MOVIE_ID, REVIEW_ROW_MAPPER, movieId);
    }
}
