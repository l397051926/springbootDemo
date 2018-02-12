package com.gennlife.springbootwebdemo2.service;

/**
 * @author liumingxin
 * @create 2018 12 13:55
 * @desc jdbcTemple 使用
 **/
public interface UserService {
    /**
     * 创建用户
     */
    void createUser(String name,Integer age);

    /**
     * 修改用户
     */
    void alterUserById(Integer id,String name,Integer age);

    /**
     * 删除指定id用户
     */

    void deleteUser(Integer id);
    /**
     * 删除所有用户
     */
    void delectAll();
}
