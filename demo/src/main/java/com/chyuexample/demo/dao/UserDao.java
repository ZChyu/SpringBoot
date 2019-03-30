package com.chyuexample.demo.dao;/*
 * @Author Chyu
 * Create on 2019/3/20 16:57
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    List<User>queryUser();
    User queryUserId(int uerId);
    int  insertUser(Map para);
    int updateUser(User user);
    int deleteUser(int userId);
    List<User> login(Map para);

}
