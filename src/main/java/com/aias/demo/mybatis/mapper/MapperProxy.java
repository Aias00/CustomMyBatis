package com.aias.demo.mybatis.mapper;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;
import com.aias.demo.mybatis.session.DefaultSqlSession;
import com.aias.demo.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class MapperProxy<T> implements InvocationHandler {
    private final SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> clazz) {
        this.sqlSession = sqlSession;
        this.mapperInterface = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperData mapperData =
                sqlSession.getConfiguration()
                        .getMapperRegistry()
                        .get(method.getDeclaringClass().getName() + "." + method.getName());
        if (null != mapperData) {
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", mapperData.getSql(), args[0]));
            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }
        return method.invoke(proxy, args);

    }
}
