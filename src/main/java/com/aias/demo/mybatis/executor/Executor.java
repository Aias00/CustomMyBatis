package com.aias.demo.mybatis.executor;

import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;

/**
 * 执行器接口
 */
public interface Executor {

    public <T> T execute(MapperData mapperData, Object parameter) throws Exception;

    public Configuration getConfiuration();
}
