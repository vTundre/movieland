package com.jk.movieland.dao.jdbc.utils;

import com.jk.movieland.utils.RequestParameters;

public class QueryBuilder {

    public static String prepareSql(String sql, RequestParameters requestParameters) {
        if (requestParameters == null || requestParameters.getSortColumnName() == null) {
            return sql;
        }
        return sql + " order by " + requestParameters.getSortColumnName() + " " + requestParameters.getSortDirection();
    }
}
