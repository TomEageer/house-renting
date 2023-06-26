package com.qf.hose.renting.controller;

import com.qf.hose.renting.common.R;
import com.qf.hose.renting.dto.UserDto;
import com.qf.hose.renting.pojo.User;
import com.qf.hose.renting.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 控制器的命名规则： 业务实体的名称 + controller
 *
 * 思考： 如果使用Servlet来实现业务功能，会存在什么问题？
 * Servlet会存在请求匹配无法精准定位
 *
 */

//RestController = ResponseBody + Controller


//@Controller标识的类就是一个控制器类
//@ResponseBody标识的类，类中所有的方法返回的结果都会传递回前端

//@RequestMapping 请求匹配，如果这个注解使用在类上，那么类中的
//所有方法都会有这个@RequestMapping中指定的前缀

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    //GetMapping 匹配GET请求
    //PostMapping 匹配POST请求
    @GetMapping
    //方法的返回值能够直接传输至前端页面，这里需要使用到消息转换器，并且是使用JSON格式的消息转换器
    public R<String> getUser(UserDto userDto){
        //如果参数在地址栏出现，我们可以直接在参数列表使用对应的DTO进行接收，接收的时候
        //不需要任何注解
        System.out.println(userDto);
        return R.ok("admin");
    }

//    public void getUser(HttpServletRequest request, HttpServletResponse resp) throws IOException {
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        UserDto userDto = new UserDto();
//        userDto.setName(name);
//        userDto.setAge(Integer.parseInt(age));
//        System.out.println(userDto);
//        resp.setContentType("application/json;charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//        writer.print(R.ok("admin"));
//        writer.flush();
//        writer.close();
//    }

    //增加用户
    @PostMapping
    //@RequestBody 注解 只能在请求参数在请求体中时使用
    //请求的参数出现的位置有3种： 请求地址后、请求体中、请求地址中
    // 请求地址后： /user?name=张
    // 请求体： {"username":"admin"}
    // 请求地址中： /user/admin,  /user/zhangsan   /user/{username}
    public R<Boolean> addUser(@RequestBody User user){
        return R.ok(userService.save(user));
    }


    // 匹配的地址 /user/login
    @PostMapping("/login")
    public R<Integer> login(@RequestBody User user){
        return R.ok(userService.login(user));
    }

    //从上面两个方法来思考：使用控制器可以精准的匹配处理的请求

}
