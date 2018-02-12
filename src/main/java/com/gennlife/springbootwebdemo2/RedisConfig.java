package com.gennlife.springbootwebdemo2;

import com.gennlife.springbootwebdemo2.redispojo.RedisObjectSerializer;
import com.gennlife.springbootwebdemo2.redispojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author liumingxin
 * @create 2018 12 17:07
 * @desc
 **/
@Configuration
public class RedisConfig  {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Student> template = new RedisTemplate<String, Student>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
