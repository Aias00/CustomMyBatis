package com.aias.demo.mybatis.executor;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;

import java.util.HashMap;
import java.util.Map;

public class CachingExecutor implements Executor {

    private final Executor delegate;
    private Configuration configuration;

    private Map<String, Object> localCache = new HashMap<>();

    public CachingExecutor(Executor executor) {
        this.delegate = executor;
        this.configuration = executor.getConfiuration();
    }

    @Override
    public <T> T execute(MapperData mapperData, Object parameter) throws Exception {
        // 调用缓存
        Object result = localCache.get(mapperData.getSql());
        if (null == result) {
            result = delegate.execute(mapperData, parameter);
            localCache.put(mapperData.getSql(), result);
        }
        return (T) result;
    }

    @Override
    public Configuration getConfiuration() {
        return this.configuration;
    }
}
