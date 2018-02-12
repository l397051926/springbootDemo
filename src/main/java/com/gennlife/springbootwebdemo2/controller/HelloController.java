package com.gennlife.springbootwebdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liumingxin
 * @create 2018 11 18:25
 * @desc
 **/
@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello word";
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host","http://blog.didispace.com");
        return "index";
    }

}
