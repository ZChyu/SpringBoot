package com.chyuexample.demo.entity;/*
 * @Author Chyu
 * Create on 2019/3/20 15:39
 * Email 604641446@qq.com
 * */

public class User {
    private Integer Id;
    private  String Name;
    private String Password;
    private String Age;
    public  User(){

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }
    @Override
    public  String toString(){
        return "User{" +
                "id=" + Id +
                ", Name='" + Name + '\'' +
                ", Password=" + Password +
                ", age=" + Age +
                '}';

    }
}
