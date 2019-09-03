package com.aias.demo.mybatis.registry;

import com.aias.demo.mybatis.bean.Test;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {
    public static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    public MapperRegistry() {
        // TODO 初始化 扫描存入方法和返回值
        methodSqlMapping.put("com.aias.demo.mybatis.mapper.TestMapper.selectById", new MapperData("select id,name from t_test where id = %d", Test.class));
    }

    public MapperData get(String nameSpace) {
        return methodSqlMapping.get(nameSpace);
    }
}
