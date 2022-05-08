package com.ht.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-05-08-23:14
 */

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\javaCode\\JDBCStudy\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "select * from test where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"小七");
        preparedStatement.setString(2,"0109219");
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
