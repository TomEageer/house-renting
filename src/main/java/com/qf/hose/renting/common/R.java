package com.qf.hose.renting.common;

import lombok.Data;

/**
 * 这个R类就是Result的意思，表示控制层方法的返回类型
 *
 * 泛型本质来说是一个类型的变量，在使用的时候会传递进来具体的值
 */
@Data
public class R<T> {

    private int status; // 服务器端的响应状态

    private String msg; // 服务器端的响应状态对应的消息提示

    private T data; //服务器传递出去的数据

    private R(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public static <E> R<E> ok(){
        return ok(null);
    }

    public static <E> R<E> ok(E data){
        return new R<>(200, "Ok", data);
    }

    public static <E> R<E> error(int status){
        return error(status, "");
    }

    public static <E> R<E> error(int status, String msg){
        return new R<>(status, msg, null);
    }
}
