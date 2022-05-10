package com.ht.mapper;

import com.ht.pojo.User;

import java.util.List;

/**
 * @author hongtao
 * @create 2022-05-10-15:28
 */

public interface UserMapper {

    List<User> selectAll();
    User selectById(int id );
}
