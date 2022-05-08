package com.ht.jdbc_demo;

import com.ht.pojo.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongtao
 * @create 2022-05-08-19:26
 */

public class Jdbc_Demo5 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/exampletest";
        String username = "root";
        String password = "123123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "select *from account";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Account> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double money = resultSet.getDouble(3);
            Account account = new Account();
            account.setAge(id);
            account.setName(name);
            account.setMoney(money);
            list.add(account);
        }
        System.out.println(list);
        resultSet.close();
        statement.close();
        connection.close();
    }
}
