package com.jk.movieland.utils;

import java.security.InvalidParameterException;
import java.util.Objects;

public class RequestParameters {
    private SortColumn sortColumnName;
    private SortDirection sortDirection;

    public RequestParameters(String ratingOrder, String priceOrder) {
        if (SortDirection.desc.name().equals(ratingOrder)) {
            sortColumnName = SortColumn.movie_rating;
            sortDirection = SortDirection.desc;
        } else if (priceOrder != null) {
            sortColumnName = SortColumn.movie_price;
            sortDirection = SortDirection.getSortDirection(priceOrder);
        }
        else {
            throw new InvalidParameterException("Wrong parameters");
        }
    }

    public SortColumn getSortColumnName() {
        return sortColumnName;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestParameters that = (RequestParameters) o;
        return Objects.equals(sortColumnName, that.sortColumnName)
                && Objects.equals(sortDirection, that.sortDirection);
    }

    private enum SortColumn {
        movie_rating,
        movie_price
    }

    private enum SortDirection {
        asc,
        desc;

        public static SortDirection getSortDirection(String s) {
            for (SortDirection sortDirection : values())
                if (sortDirection.name().equals(s)) {
                    return sortDirection;
                }
           throw new InvalidParameterException("Incorrect sorting direction");
        }
    }
}
