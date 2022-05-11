package com.ht;

import com.ht.mapper.BrandMapper;
import com.ht.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongtao
 * @create 2022-05-11-17:06
 */

public class MybatisTest {
    public static void testSelectAll() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);

        sqlSession.close();

    }

    public static void selectByIdAfter() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("请输入需要查询的ID");
        int id = Integer.parseInt(bufferedReader.readLine());
        Brand brand = brandMapper.selectByIdAfter(id);
        System.out.println(brand);
        sqlSession.close();
    }

    public static void selectByCondition() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("请输入status or companyName or brandName （不需要回车即可）");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int status = Integer.parseInt(bufferedReader.readLine());
        String companyName = bufferedReader.readLine();
        String brandName = bufferedReader.readLine();
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        Brand brands = brandMapper.selectByCondition(brand);

        System.out.println(brands);

        sqlSession.close();
    }
    

    public static int addDate() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("进入添加操作");
        String brandName = bufferedReader.readLine();
        String companyName = bufferedReader.readLine();
        String description = bufferedReader.readLine();
        int ordered = Integer.parseInt(bufferedReader.readLine());
        int status = Integer.parseInt(bufferedReader.readLine());
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);

        int count = brandMapper.addDate(brand);
        if (count > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");

        }
        sqlSession.rollback();
        sqlSession.close();
        return count;
    }

    public static int upDate() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("修改系统");

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入需要修改的ID");
        int id = Integer.parseInt(bufferedReader.readLine());
        String brandName = bufferedReader.readLine();
        String companyName = bufferedReader.readLine();
        String description = bufferedReader.readLine();
        int ordered = Integer.parseInt(bufferedReader.readLine());
        int status = Integer.parseInt(bufferedReader.readLine());
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setId(id);

        int count = brandMapper.upDate(brand);
        if (count > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        sqlSession.close();
        return count;
    }

    public static int delByName() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("删除数据");

        System.out.println("请输入需要删除的品牌");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String brandName = bufferedReader.readLine();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.delByName(brandName);
        if (count > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        sqlSession.close();
        return count;
    }

    public static int delByIds() throws IOException {
        String resource = "mybatis_practice.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("删除多条数据");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入需要删除的id(");
        int input;

        while (true) {
            String s = bufferedReader.readLine();
            if (s != null && !"".equals(s)) {
                input = Integer.parseInt(s);
                list.add(input);
            } else {
                break;
            }
        }
        int size = list.size();
        int[] ids = new int[size];
        for (int i = 0; i < size; i++) {
            ids[i] = list.get(i);
        }
        int count = brandMapper.delByIds(ids);
        if (count > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        sqlSession.close();
        return count;
    }
}
