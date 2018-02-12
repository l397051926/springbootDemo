package com.gennlife.springbootwebdemo2.redis;

import javafx.application.Application;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liumingxin
 * @create 2018 12 15:54
 * @desc
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ReidsTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void testReids(){
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
    }
}
