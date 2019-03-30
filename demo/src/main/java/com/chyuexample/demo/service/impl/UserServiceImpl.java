package com.chyuexample.demo.service.impl;/*
 * @Author Chyu
 * Create on 2019/3/21 9:35
 * Email 604641446@qq.com
 * */

import com.chyuexample.demo.dao.UserDao;
import com.chyuexample.demo.entity.User;
import com.chyuexample.demo.enums.ResultEum;
import com.chyuexample.demo.handler.UserException;
import com.chyuexample.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(int userId) {
        return userDao.queryUserId(userId);
    }
   // @Transactional //涉及的业务复杂 就用事物控制起来
    @Override
    public boolean addUser(User user) {
        if(user.getId() !=null && !"".equals(user.getId())){
            try{
                Map addMap = new HashMap();
                addMap.put("id",user.getId());
                addMap.put("name",user.getName());
                addMap.put("password",user.getPassword());
                addMap.put("age",user.getAge());
                int effecNum = userDao.insertUser(addMap);
                if (effecNum>0){
                    return  true;
                }else{
                    throw  new RuntimeException("插入用户失败!");
                }
            }catch(Exception e){
                throw new UserException(ResultEum.UNKONW_ERROR);
            }
        }else{
            throw new UserException(ResultEum.ERROR_ID);
        }
    }

    @Override
    public boolean modifyUser(User user) {
        if(user.getId() !=null && user.getId()>0){
            try{
                int effecNum = userDao.updateUser(user);
                if (effecNum>0){
                    return  true;
                }else{
                    throw  new RuntimeException("更新用户失败！");
                }
            }catch(Exception e){
                throw new RuntimeException("更新用户失败！"+ e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        if(userId>0){
            try{
                int effecNum = userDao.deleteUser(userId);
                if (effecNum>0){
                    return  true;
                }else{
                    throw  new RuntimeException("删除用户失败！");
                }
            }catch(Exception e){
                throw new RuntimeException("删除用户失败！"+ e.toString());
            }
        }else{
            throw new RuntimeException("区域id不能为空！");
        }
    }


    @Override
    public boolean loginUser(User user)   {
        if (user.getName() != null && user.getPassword() != null && user.getPassword().length()!=0 && user.getName().length()!=0  ) {
                Map data = new HashMap();
                data.put("password",user.getPassword());
                data.put("name",user.getName());
                List<User>loginFlagMap = userDao.login(data);
                System.out.print("--*****login_sql语句执行成功*****--"+user.getPassword()+"------");
                if (!loginFlagMap.isEmpty()) {
                    return true;

                } else {
                    throw new UserException(ResultEum.ERROR_NAME_PASSWORD);
            }
        }else {
            throw new UserException(ResultEum.ERROR_NULL);
        }
    }

}
