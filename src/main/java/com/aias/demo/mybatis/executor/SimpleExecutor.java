package com.aias.demo.mybatis.executor;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.handler.StatmentHandler;
import com.aias.demo.mybatis.registry.MapperData;


public class SimpleExecutor implements Executor {
    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration getConfiuration() {
        return this.configuration;
    }

    @Override
    public <T> T execute(MapperData mapperData, Object parameter) throws Exception {
        StatmentHandler handler = new StatmentHandler(configuration);
        return (T) handler.handle(mapperData, parameter);
    }

}
