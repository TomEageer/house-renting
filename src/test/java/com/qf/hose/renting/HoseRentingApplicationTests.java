package com.qf.hose.renting;

import com.qf.hose.renting.mapper.UserMapper;
import com.qf.hose.renting.pojo.User;
import com.qf.hose.renting.util.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//测试类必须使用@SpringBootTest标明
//同时还必须要保证测试类的包与启动类所在的包名一致

@SpringBootTest
class HoseRentingApplicationTests {
    //Spring提供的自动注入注解，自动注入有一个前提条件，注入的对象必须在IOC容器中存在
    @Autowired
    private UserMapper userMapper;

//    @Test //这个注解的包要注意，别引入错了
//    void addUserTest() {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword(PasswordEncoder.encode("123456"));
//        user.setName("管理员");
//        user.setPhone("13888888888");
//        user.setSex(1);
//        //Mapper接口能够执行，是因为在放入Spring IOC容器中的时候会产生一个代理实例
//        int result = userMapper.addUser(user);
//        assert result == 1;
//    }

    @Test
    void saveUserTest(){
        User user = new User();
        user.setUsername("admin1");
        user.setPassword(PasswordEncoder.encode("123456"));
        user.setName("管理员1");
        user.setPhone("13888888888");
        user.setSex(1);
        int result = userMapper.insert(user);
        assert result == 1;
    }

}
