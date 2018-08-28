package com.wangchun.mapper;

import com.wangchun.util.DynamicDataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/27.
 */
@Repository
public class UserDaoImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> getUsers(){
        DynamicDataSourceHolder.setDataSource("MySqlDataSource");
        String sql ="select * from t_user";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getUsersOracle(){
        DynamicDataSourceHolder.setDataSource("dataSource1");
        String sql ="select * from acm_user";
        return jdbcTemplate.queryForList(sql);
    }
}
