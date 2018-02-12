package com.gennlife.springbootwebdemo2.service.serviceimpl;

import com.gennlife.springbootwebdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author liumingxin
 * @create 2018 12 14:02
 * @desc
 **/
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(String name, Integer age) {
        jdbcTemplate.update("insert into user(name ,age) values(?,?)",name,age);
    }

    @Override
    public void alterUserById(Integer id, String name, Integer age) {
        jdbcTemplate.update("update user set name = ?, age = ? where id = ?",name,age,id);
    }

    @Override
    public void deleteUser(Integer id) {
        jdbcTemplate.update("delete from user where id = ?",id);
    }

    @Override
    public void delectAll() {
        jdbcTemplate.update("delete from user");
    }
}
