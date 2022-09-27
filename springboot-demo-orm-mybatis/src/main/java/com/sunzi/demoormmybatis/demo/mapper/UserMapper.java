package com.sunzi.demoormmybatis.demo.mapper;

import com.sunzi.demoormmybatis.demo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> selectAllUsers();
}
