package com.aias.demo.mybatis.executor;


import com.aias.demo.mybatis.config.Configuration;

public class ExecutorFactory {

    public static Executor DEFAULT(Configuration configuration) {
        return get(ExecutorType.SIMPLE, configuration);
    }

    public static Executor get(ExecutorType key, Configuration configuration) {
        if (ExecutorType.SIMPLE.equals(key)) {
            return new SimpleExecutor(configuration);
        }
        if (ExecutorType.SIMPLE.equals(key)) {
            return new CachingExecutor(new SimpleExecutor(configuration));
        }
        throw new RuntimeException("no executor found");
    }

}
