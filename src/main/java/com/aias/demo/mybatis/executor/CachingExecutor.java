package com.aias.demo.mybatis.executor;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;

public class CachingExecutor implements Executor {

    private final Executor delegate;
    private Configuration configuration;

    public CachingExecutor(Executor executor) {
        this.delegate = executor;
        this.configuration = executor.getConfiuration();
    }
    @Override
    public <T> T execute(MapperData mapperData, Object parameter) throws Exception {
        // TODO 调用缓存
        return delegate.execute(mapperData, parameter);
    }

    @Override
    public Configuration getConfiuration() {
        return this.configuration;
    }
}
