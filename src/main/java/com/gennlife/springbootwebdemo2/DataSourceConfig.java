package com.gennlife.springbootwebdemo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author liumingxin
 * @create 2018 12 14:32
 * @desc
 * 多数据源实现
 **/
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource PrimaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondarDataSource")
    @Qualifier("secondarDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondar")
    public DataSource SecondarDataSource(){
        return DataSourceBuilder.create().build();
    }

    //创建数据源

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "secondarDatasource")
    public JdbcTemplate secondarDatasource(@Qualifier("secondarDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
