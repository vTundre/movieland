package com.jk.movieland.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import com.jk.movieland.view.Views;

import java.util.List;

@Data
public class Movie {
    @JsonView(Views.MovieShort.class)
    private int id;
    @JsonView(Views.MovieShort.class)
    private String nameRussian;
    @JsonView(Views.MovieShort.class)
    private String nameNative;
    @JsonView(Views.MovieShort.class)
    private String yearOfRelease;
    private String description;
    @JsonView(Views.MovieShort.class)
    private double rating;
    @JsonView(Views.MovieShort.class)
    private double price;
    @JsonView(Views.MovieShort.class)
    private String picturePath;
    private List<Country> countries;
    private List<Genre> genres;
    private List<Review> reviews;

    @Override
    public String toString(){
        return "id: " + id + ";  name: " + nameNative;
    }
}
