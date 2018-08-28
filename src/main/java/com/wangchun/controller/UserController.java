package com.wangchun.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wangchun.bean.User;
import com.wangchun.bean.UserOracle;
import com.wangchun.config.DataSource;
import com.wangchun.mapper.UserDaoImpl;
import com.wangchun.mapper.UserMapper;
import com.wangchun.util.DynamicDataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/27.
 */
@RestController
public class UserController {
    @Autowired
    UserDaoImpl userDao;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/getUsers")
    public String getUsers(){
        List<Map<String, Object>> userList = userDao.getUsers();
        Gson gson = new Gson();
        String s = gson.toJson(userList);
        return s;
    }
    @RequestMapping("getUsersOracle")
    public String getUsersOracle(){
        List<Map<String, Object>> usersOracle = userDao.getUsersOracle();
        Gson gson = new Gson();
        String s = gson.toJson(usersOracle);
        return s;
    }
    @RequestMapping("/getUsers1")
    public String getUsers1(){
        List<User> users = userMapper.getUsers();
        Gson gson = new Gson();
        return gson.toJson(users);
    }
    @RequestMapping("/getUsersOracle1")
    @DataSource("dataSource1")
    public String getUsersOracle1(){
//        DynamicDataSourceHolder.setDataSource("dataSource1");
        List<UserOracle> userOracle = userMapper.getUserOracle();
        Gson gson = new Gson();
        return gson.toJson(userOracle);
    }
}
