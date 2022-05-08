package com.ht.jdbc_demo;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hongtao
 * @create 2022-05-08-16:41
 */
/*
    针对于事务
 */
public class jdbd_demo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/exampletest";
        String username = "root";
        String password = "123123";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";
        //开启事务

        try {
            //开启事务
            connection.setAutoCommit(false);
            int count1 = statement.executeUpdate(sql1);
            //制造报错
            int i = 3/0;
            int count2 = statement.executeUpdate(sql2);
            System.out.println(count1+","+count2);
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            //回滚事务
            connection.rollback();
            e.printStackTrace();
        }

        statement.close();
        connection.close();
    }
}
