package com.aias.demo.mybatis.registry;

public class MapperData<T> {

    private String sql;

    private Class<T> type;

    public MapperData(String sql, Class<T> clazz) {
        this.sql = sql;
        this.type = clazz;
    }

    public String getSql() {
        return sql;
    }

    public Class<T> getType() {
        return type;
    }

}
