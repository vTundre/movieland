package com.jk.movieland.utils;

import java.util.Objects;

public class RequestParameters {
    private SortColumn sortColumnName;
    private SortDirection sortDirection;

    public RequestParameters(SortDirection ratingOrder, SortDirection priceOrder) {
        if (ratingOrder != null && SortDirection.DESC.equals(ratingOrder)) {
            sortColumnName = SortColumn.MOVIE_RATING;
            sortDirection = ratingOrder;
        } else if (priceOrder != null) {
            sortColumnName = SortColumn.MOVIE_PRICE;
            sortDirection = priceOrder;
        }
        else {
            throw new IllegalArgumentException("Wrong parameters");
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
        MOVIE_RATING,
        MOVIE_PRICE
    }
}
