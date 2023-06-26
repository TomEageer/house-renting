package com.qf.hose.renting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.hose.renting.mapper.UserMapper;
import com.qf.hose.renting.pojo.User;
import com.qf.hose.renting.service.IUserService;
import com.qf.hose.renting.util.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service //这个注解就是业务层的注解，使用这个注解标识的类，会纳入Spring IOC容器管理
public class UseServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    //@Transactional 注解表示事务，事务是为了保证数据的正确性，只读事务能够提升查询的性能
    //这里的隔离级别设置为读已提交，这样可以防止脏读
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Override
    public int login(User user) {
        //查询包装器，就是用来构建查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //下面的这行代码就相当于where后面的条件
        wrapper.eq("username", user.getUsername());
        //调用Mybatis-plus提供的getOne方法进行查询
        User dbUser = getOne(wrapper);
        if(dbUser == null) return  -1; //账号不存在
        Integer status = dbUser.getStatus();
        if(status == 0) return -2; //账号被冻结
        String password = dbUser.getPassword();
        //对输入的密码进行加密
        String encode = PasswordEncoder.encode(user.getPassword());
        return password.equals(encode) ? 1 : 0;
    }
}
