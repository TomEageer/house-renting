package com.qf.hose.renting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.hose.renting.pojo.User;

//在mybatis-plus中，业务层必须要继承IService接口，泛型就是我们的实体
public interface IUserService extends IService<User> {
    //编写一个接口，来描述登录业务
    int login(User user);
}
