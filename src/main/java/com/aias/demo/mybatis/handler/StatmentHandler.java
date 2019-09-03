package com.aias.demo.mybatis.handler;


import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.registry.MapperData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatmentHandler {

    private final Configuration configuration;

    private final ResultSetHandler resultSetHandler;

    public StatmentHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new ResultSetHandler(configuration);
    }

    public Object handle(MapperData mapperData, Object parameter) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(mapperData.getSql(), Integer.parseInt(String.valueOf(parameter))));
            preparedStatement.execute();
            return resultSetHandler.handle(preparedStatement, mapperData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() throws SQLException {
        // TODO  从configuration中读取配置信息 并获取连接
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/idea?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
