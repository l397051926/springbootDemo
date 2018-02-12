package com.gennlife.springbootwebdemo2.controller;

import com.gennlife.springbootwebdemo2.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.*;

/**
 * @author liumingxin
 * @create 2018 12 10:39
 * @desc
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    static Map<Long,User> userMap= Collections.synchronizedMap(new HashMap<Long,User>());

    @ApiOperation(value = "获取用户列表",notes = "")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> userList=new ArrayList<User>(userMap.values());
        return userList;
    }
    @ApiOperation(value = "创建用户",notes = "根据user信息创建用户")
    @ApiImplicitParam(name = "user",value = "用户信息",required = true,dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String putUser(@ModelAttribute User user){
        userMap.put(user.getId(),user);
        return "succefull";
    }
    @ApiOperation(value = "获取用户",notes = "根据用户id获取用户")
    @ApiImplicitParam(name="id",value = "用户id",dataType = "long",required = true)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        User user =userMap.get(id);
        return user;
    }
    @ApiOperation(value = "添加用户",notes = "根据用户id添加用户")
    @ApiImplicitParams({


            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Long", required = true),
            @ApiImplicitParam(name = "user", value = "用户信息", dataType = "User", required = true)
    }
    )
    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String putUser(@PathVariable Long id ,@ModelAttribute User user){
        User u=userMap.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        userMap.put(id,u);
        return "succefull";
    }
    @ApiOperation(value = "删除用户",notes = "根据用户id删除指定用户")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "Long",required = true)
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        userMap.remove(id);
        return "succefull";
    }


}
