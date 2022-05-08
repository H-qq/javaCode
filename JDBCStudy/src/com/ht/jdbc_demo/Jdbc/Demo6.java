package com.ht.jdbc_demo.Jdbc;

import java.sql.*;

/**
 * @author hongtao
 * @create 2022-05-08-20:02
 */

public class Demo6 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/exampletest?userSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "123123";

        String name = "小七";
        String pwd = "010919";

        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from test where username = ? and password = ?";
        System.out.println(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("登入成功");
        }else{
            System.out.println("登入失败");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
