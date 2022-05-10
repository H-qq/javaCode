package com.ht.example;

import com.ht.pojo.brand;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-05-09-15:39
 */

public class BrandTest {
    public static void main(String[] args) throws Exception {
        // add_brands();
        DeleteById();
    }

    /*
    进行查找功能
     */
    @Test
    public void Select_Date() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\javaCode\\JDBCStudy\\src\\properties.properties"));
        String url = (String) properties.get("url");
        String pwd = (String) properties.get("password");
        String username = (String) properties.get("username");

        Connection connection = DriverManager.getConnection(url, username, pwd);
        String sql = "select * from tb_brand";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        brand brands = null;
        List<brand> lists = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            brands = new brand();
            brands.setId(id);
            brands.setbrandName(brandName);
            brands.setcompanyName(companyName);
            brands.setOrdered(ordered);
            brands.setDescription(description);
            brands.setStatus(status);
            lists.add(brands);
        }
        System.out.println(lists);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    /*
    添加功能
     */

    public static void add_brands() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\javaCode\\JDBCStudy\\src\\properties.properties"));
        String url = (String) properties.get("url");
        String pwd = (String) properties.get("password");
        String username = (String) properties.get("username");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String brand_name = bufferedReader.readLine();
        String company_name = bufferedReader.readLine();
        int ordered = Integer.parseInt(bufferedReader.readLine());
        String description = bufferedReader.readLine();
        int status = Integer.parseInt(bufferedReader.readLine());


        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status)" +
                "values(?,?,?,?,?) ";

        Connection connection = DriverManager.getConnection(url, username, pwd);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand_name);
        preparedStatement.setString(2, company_name);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);
        int count = preparedStatement.executeUpdate();

        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        bufferedReader.close();
        preparedStatement.close();
        connection.close();
    }


    /*
    修改更新数据
     */
    public static void UpdateById() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\javaCode\\JDBCStudy\\src\\properties.properties"));
        String url = (String) properties.get("url");
        String pwd = (String) properties.get("password");
        String username = (String) properties.get("username");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入需要修改的ID");
        int id = Integer.parseInt(bufferedReader.readLine());
        String brand_name = bufferedReader.readLine();
        String company_name = bufferedReader.readLine();
        int ordered = Integer.parseInt(bufferedReader.readLine());
        String description = bufferedReader.readLine();
        int status = Integer.parseInt(bufferedReader.readLine());

        Connection connection = DriverManager.getConnection(url, username, pwd);
        String sql = "update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=?"
                + " where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand_name);
        preparedStatement.setString(2, company_name);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);
        preparedStatement.setInt(6, id);
        System.out.println(sql);
        int count = preparedStatement.executeUpdate();

        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        bufferedReader.close();
        preparedStatement.close();
        connection.close();

    }

    public static void DeleteById() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\javaCode\\JDBCStudy\\src\\properties.properties"));
        String url = (String) properties.get("url");
        String pwd = (String) properties.get("password");
        String username = (String) properties.get("username");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入需要删除的ID");
        int id = Integer.parseInt(bufferedReader.readLine());
        String sql = "delete from tb_brand where id=?";
        Connection connection = DriverManager.getConnection(url, username, pwd);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        System.out.println(sql);
        int count = preparedStatement.executeUpdate();

        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        bufferedReader.close();
        preparedStatement.close();
        connection.close();
    }


}
