package com.sunzi.demoormmybatis.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Slience
 * @version 1.0
 */

@Data
public class SysUser {

    private Integer id;

    private String userName;

    private String userPassword;

    private String userEamil;

    private String userInfo;

    private byte[] headImg;

    private Date createTime;
}
