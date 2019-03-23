package com.jk.movieland.dao.jdbc.utils;

import com.jk.movieland.utils.RequestParameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryBuilderTest {
    @Test
    public void testPrepareSql() {
        String result = QueryBuilder.prepareSql("select movie_name from movie", new RequestParameters(null, "desc"));
        assertEquals( "select movie_name from movie order by movie_price desc", result);
    }
}
