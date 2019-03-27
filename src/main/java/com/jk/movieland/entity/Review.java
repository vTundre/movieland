package com.jk.movieland.entity;

import lombok.Data;

@Data
public class Review {
    private int id;
    private User user;
    private String text;
}
