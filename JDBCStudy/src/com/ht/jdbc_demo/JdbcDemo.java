package com.ht.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hongtao
 * @create 2022-05-08-16:02
 */
/*
JDBC快速入门

 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1,注册驱动  可以省略
       // Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/exampletest";
        String username = "root";
        String password = "123123";
        Connection connection = DriverManager.getConnection(url, username, password);
        //定义sql 语句
        String sql = "update account set money = 2000 where id = 1";

        //获取sql执行对象
        Statement statement = connection.createStatement();

        //执行sql
        int count = statement.executeUpdate(sql);
        System.out.println(count);

        //释放资源
        statement.close();
        connection.close();

    }
}
