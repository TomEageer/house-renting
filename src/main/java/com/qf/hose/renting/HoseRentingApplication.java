package com.qf.hose.renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot工程内置了Tomcat，要启动这个Tomcat，只需要在启动类上添加上
//@SpringBootApplication注解即可， Tomcat容器默认端口是8080

@SpringBootApplication
public class HoseRentingApplication {

    public static void main(String[] args) {
        //主方法中，必须有这一行代码，第一个参数就是我们启动的类字节码对象，
        //第二个参数就是我们配置的args
        SpringApplication.run(HoseRentingApplication.class, args);
    }

}
