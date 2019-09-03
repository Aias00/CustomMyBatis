package com.aias.demo.mybatis.session;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.executor.Executor;
import com.aias.demo.mybatis.executor.SimpleExecutor;
import com.aias.demo.mybatis.mapper.MapperProxy;
import com.aias.demo.mybatis.registry.MapperData;

import java.lang.reflect.Proxy;

/**
 * session默认实现
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public DefaultSqlSession() {
    }

    @Override
    public <T> T selectOne(MapperData mapperData, Object parameter) throws Exception {
        return this.executor.execute(mapperData, parameter);
    }

    @Override
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperProxy(this, clazz));
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }
}
