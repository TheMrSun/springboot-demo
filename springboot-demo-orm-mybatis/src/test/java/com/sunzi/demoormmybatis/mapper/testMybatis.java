package com.sunzi.demoormmybatis.mapper;

import com.sunzi.demoormmybatis.demo.entity.SysUser;
import com.sunzi.demoormmybatis.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */

@Slf4j
@SpringBootTest
public class testMybatis {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAllUser() {
        List<SysUser> users = userMapper.selectAllUsers();
        log.info("查询所有用户 {}",users.toString());
    }

}
