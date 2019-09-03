package com.aias.demo.test;

import com.aias.demo.mybatis.config.Configuration;
import com.aias.demo.mybatis.executor.ExecutorFactory;
import com.aias.demo.mybatis.mapper.TestMapper;
import com.aias.demo.mybatis.session.DefaultSqlSession;
import com.aias.demo.mybatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class AiasTest {

    @Test
    public void test() {
        System.out.println("test");
        DefaultSqlSession sqlSession = new DefaultSqlSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        com.aias.demo.mybatis.bean.Test test = testMapper.selectById(1);
        System.out.println(test);

    }

    @Test
    public void test2() throws Exception {
        System.out.println("test");
        Configuration configuration = new Configuration();
        configuration.setScanPath("com.aias.demo.mybatis.mapper");
        configuration.build();
        SqlSession sqlSession = new DefaultSqlSession(configuration, ExecutorFactory.DEFAULT(configuration));
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        com.aias.demo.mybatis.bean.Test test = testMapper.selectById(1);
        System.out.println(test);

    }


}
