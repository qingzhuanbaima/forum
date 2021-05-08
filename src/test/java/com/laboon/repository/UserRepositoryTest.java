package com.laboon.repository;

import com.laboon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void updateUser(){
        User user=new User();
        user.setUsername("lxj");
        user.setPassword("qwerty");
        userRepository.save(user);
    }
}