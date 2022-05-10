package com.ht;

import com.ht.mapper.UserMapper;
import com.ht.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hongtao
 * @create 2022-05-10-15:35
 */

public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession 对象，执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
/*
        //3.执行sql
        List<User> users = sqlSession.selectList("test.selectAll");*/
        //3.1获取UserMapper代理类型
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);


        //4.释放资源
        sqlSession.close();




    }

}
