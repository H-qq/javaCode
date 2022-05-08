package com.ht.jdbc_demo;

import java.sql.*;

/**
 * @author hongtao
 * @create 2022-05-08-17:31
 */

public class Jdbc_Demo4 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/exampletest";
        String username = "root";
        String password = "123123";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String sql = "select *from account";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);//相当于以下
            //resultSet.getInt("id");  与上面相同
            String name = resultSet.getString(2);
            double money = resultSet.getDouble(3);
            System.out.println(id+"\t"+name+"\t"+money);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
