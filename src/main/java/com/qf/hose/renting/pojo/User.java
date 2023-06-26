package com.qf.hose.renting.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    //如果类中的属性名与数据表中的字段名一致，那么可以不使用注解标识
    //如果不一致，可能才需要使用注解标明
    private String username;

    private String password;

    private String name;

    private Integer sex = 0;

    private String phone;

    private Integer status = 1;

    //属性名与字段不一样，但是属性名采用的是驼峰命名法，也可以不使用注解表明，
    //mybatis-plus可以自动匹配
    @TableField("created_time")
    private LocalDateTime createdTime = LocalDateTime.now();

    private LocalDateTime updateTime  = LocalDateTime.now();

    private Integer roleId;
}
