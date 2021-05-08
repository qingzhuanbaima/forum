package com.laboon.controller;

import com.laboon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void logintest(){
        User user=new User();
        user.setUsername("faff");
        user.setPassword("123456");
        userController.login(user);
    }

    @Test
    void regtest(){
        User user=new User();
        user.setUsername("laboon");
        user.setPassword("123456");
        userController.register(user);
    }

//    @Test
//    void getuser(){
//        User user=new User();
//        user.setUsername("laboon");
//        System.out.println(userController.getUser(user));
//    }

    @Test
    void updateuser(){
        User user=new User();
        user.setUsername("lxj");
        user.setPassword("qwerty");
        user.setBirthday("1999-02-15");
        user.setTel("88888888");
        user.setMail("9884@dakok");
        user.setIntroduction("aksndkjahdjkdajksdakjndaskjndajknbdaj");
        userController.updateUser(user);
    }
}