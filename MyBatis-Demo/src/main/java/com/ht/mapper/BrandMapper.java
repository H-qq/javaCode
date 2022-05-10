package com.ht.mapper;

import com.ht.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hongtao
 * @create 2022-05-10-16:20
 */

public interface BrandMapper {
    /*
    查询所有
     */
    List<Brand> selectAll();
    Brand selectByIdBrand(int id);
    /*
    条件查询
    1、散装参数：如果方法有多个参数，需要使用@Param（"sql 占位符名称"）类型  a

    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,
   @Param("brandName")String brandName);
 */
    /*
    2、封装对象方法
     List<Brand> selectByCondition(Brand brand);
     */
   /*
   3、Map方法

    */
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    int  updateAll(Brand brand);

    int deleteAll(int id);

    int deleteByiIds(@Param("ids")int[] ids);
}
