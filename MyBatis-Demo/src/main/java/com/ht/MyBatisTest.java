package com.ht;

import com.ht.mapper.BrandMapper;
import com.ht.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hongtao
 * @create 2022-05-10-15:57
 */

public class MyBatisTest {
    @Test
    public void tesSelectAll() throws IOException {
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        int  id  = 1;
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        Brand brand = brandMapper.selectByIdBrand(id);
        System.out.println(brand);
        sqlSession.close();
    }
     @Test
     public void testSelectByCondition() throws IOException {
         int status = 1;
         String companyName = "华为";
         String brandName = "华为";

         //处理参数
         companyName ="%"+companyName+"%";
         brandName ="%"+brandName+"%";

      /*   //方式二的：封装对象
         Brand brand = new Brand();
         brand.setStatus(status);
         brand.setCompanyName(companyName);
         brand.setBrandName(brandName);
*/
         Map map = new HashMap();
        // map.put("status",status);
         map.put("companyName",companyName);
        // map.put("brandName",brandName);

         //1.加载MyBatis核心配置文件
         String resource = "mybatis-config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         //2.获取sqlSession对象
         SqlSession sqlSession = sqlSessionFactory.openSession();
         //3.获取Mapper接口代理对象
         BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
         //执行方法
         List<Brand> brands = brandMapper.selectByCondition(map);
         System.out.println(brands);
         sqlSession.close();
     }
     @Test
    public void selectByConditionSingle() throws IOException {
         //1.加载MyBatis核心配置文件
         String resource = "mybatis-config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

         SqlSession sqlSession = sqlSessionFactory.openSession();
         Brand brand = new Brand();

         int status= 1;
         String companyName = "华为";
         String brandName = "华为";

         companyName = "%"+companyName+"%";
         brandName = "%"+brandName+"%";
         /*brand.setBrandName(brandName);
         brand.setCompanyName(companyName);
         brand.setStatus(status);*/

         BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
         List<Brand> brands = brandMapper.selectByConditionSingle(brand);
         System.out.println(brands);
         sqlSession.close();
     }
     @Test
    public void addAll() throws IOException {
         //1.加载MyBatis核心配置文件
         String resource = "mybatis-config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

         SqlSession sqlSession = sqlSessionFactory.openSession();
         //brand_name, company_name, ordered, description, status
         String brandName = "一加";
         String companyName = "一加公司";
         int ordered = 99;
         String description = "一加手机";
         int status  = 1;
         Brand brand = new Brand();
         brand.setStatus(status);
         brand.setBrandName(brandName);
         brand.setCompanyName(companyName);
         brand.setDescription(description);
         brand.setOrdered(ordered);
         BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
         brandMapper.add(brand);
         //提交事务
         sqlSession.commit();
         sqlSession.close();
     }
    @Test
    public void addGetId() throws IOException {
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //brand_name, company_name, ordered, description, status
        String brandName = "联想";
        String companyName = "联想公司";
        int ordered = 32;
        String description = "联想手机";
        int status  = 1;
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateAll() throws IOException {
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //brand_name, company_name, ordered, description, status
        String brandName = "荣耀";
        String companyName = "荣耀公司";
        int ordered = 4;
        String description = "荣耀手机";
        int status  = 1;
        int id = 4;
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.updateAll(brand);
        System.out.println(count);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteAll() throws IOException {
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //brand_name, company_name, ordered, description, status
        int id = 6;

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.deleteAll(id);
        System.out.println(count);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteIds() throws IOException {
        //1.加载MyBatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //brand_name, company_name, ordered, description, status
        int[] ids = {3,5};

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.deleteByiIds(ids);
        System.out.println(count);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
