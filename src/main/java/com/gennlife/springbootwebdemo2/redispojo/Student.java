package com.gennlife.springbootwebdemo2.redispojo;


import java.io.Serializable;

/**
 * @author liumingxin
 * @create 2018 12 16:05
 * @desc
 **/
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private String userName;
    private Integer age;

    public Student(String userName,Integer age){
        this.userName=userName;
        this.age=age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}