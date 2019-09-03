package com.aias.demo.mybatis.handler;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetHandler {

    private final Configuration configuration;

    public ResultSetHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    public Object handle(PreparedStatement preparedStatement, MapperData mapperData) {
        try {
            Object resultObj = new DefaultObjectFactory().create(mapperData.getType());
            ResultSet rs = preparedStatement.getResultSet();
            if (rs.next()) {
                for (Field field : resultObj.getClass().getDeclaredFields()) {
                    setValue(resultObj, field, rs);
                }
            }
            return resultObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setValue(Object resultObj, Field field, ResultSet rs) throws Exception {
        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        setMethod.invoke(resultObj, getResult(field, rs));
    }

    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }

    private Object getResult(Field field, ResultSet rs) throws SQLException {
        //TODO 自定义type handles
        Class<?> type = field.getType();
        if (Integer.class == type) {
            return rs.getInt(field.getName());
        }
        if (String.class == type) {
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }
}
