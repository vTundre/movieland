package com.jk.movieland.utils;

import java.beans.PropertyEditorSupport;

public class SortDirectionConverter extends PropertyEditorSupport {
    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(SortDirection.getSortDirection(text));
    }
}
