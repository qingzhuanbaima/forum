package com.laboon.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleControllerTest {

    @Autowired
    ArticleController articleController;

    @Test
    void findbylab(){
        System.out.println(articleController.findAllByLabel("运动"));
    }

}