package com.aias.demo.mybatis.config;


import com.aias.demo.mybatis.registry.MapperRegistry;

/**
 * 配置
 */
public class Configuration {

    private String scanPath;

    private MapperRegistry mapperRegistry = new MapperRegistry();

    public Configuration setScanPath(String scanPath) {
        this.scanPath = scanPath;
        return this;
    }

    public void build() throws Exception {
        if (null == scanPath || scanPath.length() < 1) {
            throw new Exception("scan path is null");
        }
        // TODO 获取指定路径下的mapper文件  读取并加载

    }


    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }
}
