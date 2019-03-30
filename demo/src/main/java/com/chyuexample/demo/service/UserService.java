package com.chyuexample.demo.service;/*
 * @Author Chyu
 * Create on 2019/3/21 9:28
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserList();
    User getUserById(int userId);
    boolean addUser(User user);
    boolean modifyUser(User user);
    boolean deleteUser(int userId);
    boolean loginUser(User user);


}
