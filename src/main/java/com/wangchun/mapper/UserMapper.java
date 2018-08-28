package com.wangchun.mapper;

import com.wangchun.bean.User;
import com.wangchun.bean.UserOracle;
import com.wangchun.config.DataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/27.
 */
@Repository
public interface UserMapper {
    List<User> getUsers();
//    @DataSource("dataSource1")
    List<UserOracle> getUserOracle();
}
