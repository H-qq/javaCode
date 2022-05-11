package com.ht.mapper;

import com.ht.pojo.Brand;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hongtao
 * @create 2022-05-11-15:22
 */

public interface BrandMapper {


    List<Brand> selectAll();

    Brand selectByIdAfter(int id);

    Brand selectByCondition(Brand brand);

    int addDate(Brand brand);

    int upDate(Brand brand);

    int delByName(String brandName);

    int delByIds(@Param("ids") int[] ids);

}
