package com.qf.hose.renting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.hose.renting.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//Mybatis只需要编写一个Mapper接口，这个命名规则与控制器的命名规则一致


//在Spring整合了Mybatis之后，需要在Mapper接口上添加@Mapper注解，这个接口才会
//产生代理实例
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 添加一个用户
     * @param user 用户信息
     * @return
     */
//    int addUser(@Param("user") User user); //@Param就是给这个参数取了一个别名，这个别名就可以在mapper的xml文件中使用
}
