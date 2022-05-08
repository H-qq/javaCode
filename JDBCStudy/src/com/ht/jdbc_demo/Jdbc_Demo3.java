package com.ht.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hongtao
 * @create 2022-05-08-17:00
 */

public class Jdbc_Demo3 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/exampletest";
        String username = "root";
        String password = "123123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "insert  into account(id,name,money) values (3,'小七',3200)";
        int i = statement.executeUpdate(sql);
        if (i>0){
            System.out.println("新增成功");
        }else
            System.out.println("新增失败");

        statement.close();
        connection.close();
    }
}
