package com.sun.service;

import org.springframework.stereotype.Service;

@Service("userService1")
public class UserService1 {

    public void login(){
        System.out.println("用户登录");
        //int i =  1/0;
        return;
    }

    public void register(){
        System.out.println("用户注册");
    }


}
