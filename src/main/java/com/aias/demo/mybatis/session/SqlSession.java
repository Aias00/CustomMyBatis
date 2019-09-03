package com.aias.demo.mybatis.session;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;

public interface SqlSession {

    public <T> T selectOne(MapperData mapperData, Object parameter) throws Exception;

    public <T> T getMapper(Class<T> clazz);

    public Configuration getConfiguration();


}
