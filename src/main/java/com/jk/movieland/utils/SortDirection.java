package com.jk.movieland.utils;

public enum SortDirection {
    ASC,
    DESC;

    public static SortDirection getSortDirection(String s) {
        for (SortDirection sortDirection : values())
            if (sortDirection.name().equalsIgnoreCase(s)) {
                return sortDirection;
            }
        throw new IllegalArgumentException("Incorrect sorting direction");
    }
}